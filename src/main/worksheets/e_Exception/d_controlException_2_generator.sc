import scala.util.control.Exception._


// TODO -me-  lt's write an handler which catch the
//            - NumberFormatException -> return 0
//              and
//            - IllegalArgumentException -> return -1
val handleIntConverting:Catch[Int] = ???


// TODO -me-  "42".toInt and use handleIntConverting
val test1: Int = ???
assert(test1 == 42)


// TODO -1-  "abc42def".toInt and use handleIntConverting
val test2: Int = ???
assert(test2 == 0)


// TODO -2-  use handleIntConverting and throw an IllegalArgumentException
//           write the assert statement before you implement


// TODO -3-  what should happend if you throw an
//           IndexOutOfBoundsException in withApply?


// TODO -me-  short analogy to try/catch
