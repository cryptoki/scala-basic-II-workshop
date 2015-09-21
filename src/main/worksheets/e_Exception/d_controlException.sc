import java.util.NoSuchElementException

import scala.util.Try
import scala.util.control.Exception._

// ====================================
// -1- INTRO
// ====================================
//
/**
 * compose exception handlers
 *
 * Scala Documentation - scala.util.control.Exception
 * ===================
 * This class differs from `scala.util.Try` in that it focuses on
 * composing exception handlers rather than composing behavior.
 */
// allCatch
// TODO -me-  use allCatch and nonFatalCatch with opt
//            use "42".toInt and "abc".toInt
val opt1:Option[Int] = allCatch.opt("42".toInt)
val opt2:Option[Int] = nonFatalCatch.opt("abc".toInt)


// TODO -me-  use allCatch with withTry
//            use "42".toInt and "abc".toInt
val try1:Try[Int] = allCatch.withTry("abc".toInt)
val try2:Try[Int] = allCatch.withTry("42".toInt)
//
//
// ====================================
// -2- Generator
// ====================================
//
// TODO -me-  lt's write an handler which catch the
//            - NumberFormatException -> return 0
//              and
//            - IllegalArgumentException -> return -1
/**
 * container which catch the defined exception
 */
val handleIntConverting = catching[Int](
    classOf[NumberFormatException],
    classOf[IllegalArgumentException])

  .withApply(e => {
    println("oh. we have to fallback to default values")
    e match {
      case e: NumberFormatException => 0
      case _:Throwable => -1
    }
})


// TODO -me-  "42".toInt and use handleIntConverting
val test1: Int = handleIntConverting {"42".toInt}
assert(test1 == 42)


// TODO -1-  "abc42def".toInt and use handleIntConverting
val test2: Int = handleIntConverting {"abc42def".toInt}
assert(test2 == 0)

//
// TODO -2-  use handleIntConverting and throw an IllegalArgumentException
//           write the assert statement before you implement
val test3: Int = handleIntConverting {throw new IllegalArgumentException}
assert(test3 == -1)

//
// TODO -3-  what should happend if you throw an
//           IndexOutOfBoundsException in withApply?
val test4: Int = handleIntConverting {
  "42".toInt
//  throw new IndexOutOfBoundsException
}

//
//
// ====================================
// -3- Handling
// ====================================
//
// TODO -me-  short analogy to try/catch
val test5: Int = handling[Int](classOf[NumberFormatException])
  .by (_ =>1) apply "sd".toInt

// TODO -1-  can u identify the analogy?
val test6: Int = try {
  "sb".toInt
}
catch {
  case _: NumberFormatException => 1
}

assert(test5 == test6)