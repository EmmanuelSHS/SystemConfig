import classTagTest.ClassTagTest._

object mainTest {
    def main(args: Array[String]) {
        println("1")
        val instance = getInstance[Int, String]((1, "String"))
        instance.output[Double](1.2)
    }
}
