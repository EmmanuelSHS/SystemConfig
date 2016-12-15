package classTagTest

import scala.reflect.ClassTag
class ClassTagTest[K, V](x: (K, V)) (implicit tk: ClassTag[K], tv: ClassTag[V]) {
    def output[C](output: C) (implicit ct: ClassTag[C]) {
        println(output)
        output match {
            case _: Int => println("Int")
            case _: String => println("String")
            case _: Double => println("Double")
        }
    }
}

object ClassTagTest {
    def getInstance[K, V](x: (K, V)) (implicit kt: ClassTag[K], vt: ClassTag[V]): ClassTagTest[K, V] = {
        new ClassTagTest(x)
    }
}
