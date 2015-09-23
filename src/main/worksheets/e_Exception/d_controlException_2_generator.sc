import scala.util.control.Exception._


// Creates a `Catch` object which will catch any of the supplied exceptions.
// TODO -me-  lt's write an handler which catch the
//            - NumberFormatException -> return 0
//              and
//            - IllegalArgumentException -> return -1
val handleIntConverting:Catch[Int] = ???


// TODO -me-  "42" / "abc42def".toInt and use handleIntConverting
val test1: Int = handleIntConverting.apply("42".toInt)
val test2: Int = handleIntConverting("abc42def".toInt)
assert(test1 == 42)
assert(test2 == 0)



// TODO -1-  use handleIntConverting and throw an IllegalArgumentException
//           write the assert statement before you implement


