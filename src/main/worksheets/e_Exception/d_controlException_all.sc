import java.util.NoSuchElementException

import scala.util.Try
import scala.util.control.Exception._
import scala.util.control.NonFatal

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
/** TODO -me-  usage of NonFatal */
val nonFatal: Int = try {
  "abc".toInt
} catch {
  case NonFatal(e) => -1
}


// TODO -me-  use allCatch and nonFatalCatch with
//            1) opt  and  2) withTry
//            use "42".toInt and "abc".toInt
val opt1:Option[Int] = allCatch[Int].opt("42".toInt)
val opt2:Try[Int] = nonFatalCatch[Int].withTry("abc".toInt)


// ==> PUI legalInformation


//
// ====================================
// -2- Generator
// ====================================

// Creates a `Catch` object which will catch any of the supplied exceptions.
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


// TODO -me-  "42" / "abc42def".toInt and use handleIntConverting
val test1: Int = handleIntConverting.apply("42".toInt)
val test2: Int = handleIntConverting("abc42def".toInt)
assert(test1 == 42)
assert(test2 == 0)

//
// TODO -2-  use handleIntConverting and throw an IllegalArgumentException
//           write the assert statement before you implement
val test3: Int = handleIntConverting {throw new IllegalArgumentException}
assert(test3 == -1)


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