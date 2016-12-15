package org.apache.spark.rdd

import java.nio.ByteBuffer

import scala.reflect.ClassTag

import com.datastax.spark.connector._
import com.datastax.spark.connector.cql._

import org.apache.spark._
import org.apache.spark.rdd._
import org.apache.spark.rdd.RDD._
import org.apache.spark.rdd.DeltaParallelCollectionRDD
import org.apache.spark.rdd.DeltaOperation._

class DeltaCassandra[K, V](sc: SparkContext) (implicit kt: ClassTag[K], vt: ClassTag[V]) {
  val keyspace = "foos"
  val nodename = "foo"

  // assume no duplicate keys
  val orig = nodename
  val add = nodename + "_add"
  val del = nodename + "_del"
  val idx = nodename + "_idx"

  val duration = 30

  def createSyntax(tablename: String): String = {
    val head = "CREATE TABLE IF NOT EXISTS " + keyspace + "." + tablename
    if (tablename == del || tablename == idx)
      head + "(timestamp bigint, key blob, value blob, PRIMARY KEY (key,timestamp, value));"
    else
      head + "(key blob, value blob, PRIMARY KEY (key, value));"
  }

  def createKeyspace() {
    //TODO: tunning replication strategy
    val session = CassandraConnector(sc.getConf).openSession()
    session.execute("CREATE KEYSPACE IF NOT EXISTS " + keyspace + " WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1 };")
    List(orig, add, del, idx).foreach(x => session.execute(createSyntax(x)))
    session.close()
  }

  def deleteKeyspace() {
    val session = CassandraConnector(sc.getConf).openSession()
    val dropSyntax = "DROP KEYSPACE IF EXISTS " + keyspace + ";"

    session.execute(dropSyntax)
    session.close()
  }

  def anyToBit[C](input: C) (implicit ct: ClassTag[C]): Array[Byte] = {
    val bitBuffer = SparkEnv.get.serializer.newInstance().serialize(input)
    val bitArray = new Array[Byte](bitBuffer.limit)
    bitBuffer.get(bitArray)
    bitArray
  }

  def bitToAny[C](input: Array[Byte]) (implicit ct: ClassTag[C]): C = {
    val bitBuffer = SparkEnv.get.serializer.newInstance()
    val intVal = bitBuffer.deserialize[C](ByteBuffer.wrap(input))
    intVal
  }

  // to table
  // timestamp: insertion time
  def rddToCassandra(foo: RDD[(K, V)], timestamp: Int) {
    def makeDelRdd(ts: Int): RDD[(Int, Array[Byte], Array[Byte])] = {
      sc.parallelize(foo.deltaRdd.get.collect.filter(x => x._2 == Del).map(x => (ts, anyToBit[K](x._1._1), anyToBit[V](x._1._2))).toList)
    }

    lazy val expiration = timestamp + duration

    lazy val origRdd = sc.parallelize(foo.collect.map(x => (anyToBit(x._1), anyToBit(x._2))).toList)
    lazy val addRdd = sc.parallelize(foo.deltaRdd.get.collect.filter(x => x._2 == Add).map(x => (anyToBit[K](x._1._1), anyToBit[V](x._1._2))).toList)
    lazy val delRdd = makeDelRdd(expiration)
    lazy val idxRdd = makeDelRdd(timestamp)

    origRdd.saveToCassandra(keyspace, orig, SomeColumns("key" as "_1", "value" as "_2")) 
    addRdd.saveToCassandra(keyspace, add, SomeColumns("key" as "_1", "value" as "_2"))
    delRdd.saveToCassandra(keyspace, del, SomeColumns("timestamp" as "_1", "key" as "_2", "value" as "_3"))
    idxRdd.saveToCassandra(keyspace, idx, SomeColumns("timestamp" as "_1", "key" as "_2", "value" as "_3"))
  }

  // All values from cassandra to Rdd
  // timestamp = current / expire time
  def cassandraToRdd(timestamp: Int = 0, win: Int = 0): RDD[(K, V)] = {
    // currT is provided by class mbr currT
    def makeDeltaRdd(origList: List[(K, V)], addList: List[(K, V)], delList: List[(K, V)]): RDD[(K, V)] = {
      var retRdd = sc.parallelize(origList)
      val retDeltaRdd = new DeltaParallelCollectionRDD(sc, retRdd, addList, delList)
      retRdd.deltaRdd = Some(retDeltaRdd)
      
      retRdd
    }

    def listFromCassandra(tablename: String): List[(K, V)] = {
      if (tablename == del) {
        // TODO: dont have to change in _1 _2 format 
        val table = sc.cassandraTable[(Array[Byte], Int, Array[Byte])](keyspace, tablename)
        table.collect.map(x => (bitToAny[K](x._1), bitToAny[V](x._3))).toList
      } else if (tablename == idx) {
        val minT = timestamp - win
        val table = sc.cassandraTable[(Array[Byte], Int, Array[Byte])](keyspace, tablename).where("timestamp >= ? AND timestamp <= ?", minT, timestamp) 
        table.collect.map(x => (bitToAny[K](x._1), bitToAny[V](x._3))).toList
      } else {
        val table = sc.cassandraTable[(Array[Byte], Array[Byte])](keyspace, tablename)
        table.collect.map(x => (bitToAny[K](x._1), bitToAny[V](x._2))).toList
      }
    }

    lazy val origList = listFromCassandra(orig)
    lazy val addList = listFromCassandra(add)
    lazy val delList = if (win != 0) listFromCassandra(del) else listFromCassandra(idx)

    makeDeltaRdd(origList, addList, delList)
  }

  // merge del records
  // merge from earliest till designated (usually today) date
  // timestamp: curr / expire time
  def mergeDelRecords(timestamp: Int, range: Boolean) {
    // merge & empty add table
    def mergeAdd() {
      def delAllAdd() {
        val session = CassandraConnector(sc.getConf).openSession()
        val delAll = "TRUNCATE " + keyspace + "." + add 
        session.execute(delAll)
        session.close()
      }

      val addRdd = sc.cassandraTable[(Array[Byte], Array[Byte])](keyspace, add)
      addRdd.saveToCassandra(keyspace, orig)
      delAllAdd()
    }

    // merge delete
    def mergeDel() {
      lazy val session = CassandraConnector(sc.getConf).openSession()

      def getDelRdd(): RDD[(Array[Byte], Int, Array[Byte])] = {
        // range query only allowed on secondary & clustered columns
        if (range == true) 
          sc.cassandraTable[(Array[Byte], Int, Array[Byte])](keyspace, del).where("timestamp <= ? ", timestamp)
        else 
          sc.cassandraTable[(Array[Byte], Int, Array[Byte])](keyspace, del).where("timestamp = ? ", timestamp)
      }

      val delRdd = getDelRdd()
      

      // use batch syntax to avoid communication overhead
      def mergeOneTable(tablename: String) {
        def delSyntax(ts: Int, key: String, tablename: String): String = {
          // no duplicate key, thus key is enought
          val head = "DELETE FROM " + keyspace + "." + tablename  + " WHERE key = " + key
          if (tablename == del)
            head + " AND timestamp = " + ts + "; "
          else if (tablename == idx)
            head + " AND timestamp = " + (ts - duration) + "; "
          else
            head + "; "
        }

        def getHexString(input: Array[Byte]): String = {
          "0x" + input.map("%02x" format _).mkString
        }

        lazy val delBatch = delRdd.collect.foldLeft(
          "BEGIN BATCH ") {(x: String, y: (Array[Byte], Int, Array[Byte])) => 
                          x + delSyntax(y._2, getHexString(y._1), tablename)} + " APPLY BATCH;"

        session.execute(delBatch)
      }

      // order & remember that RDD is lazy evaluated
      List(orig, idx, del).foreach(x => mergeOneTable(x))
      // notice the first n-th records in idx is those in del

      session.close()
    }

    mergeDel()
    mergeAdd()
  }

}


object DeltaCassandra {
  def getDeltaCassandraInstance[K, V](sc: SparkContext) 
    (implicit kt: ClassTag[K], vt: ClassTag[V]): DeltaCassandra[K, V] = new DeltaCassandra(sc)
}
