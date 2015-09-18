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
val opt1:Option[Int] = allCatch.opt("42".toInt)
val opt2:Option[Int] = nonFatalCatch.opt("abc".toInt)

val try1:Try[Int] = allCatch.withTry("abc".toInt)
val try2:Try[Int] = allCatch.withTry("42".toInt)
//
//
// ====================================
// -2- Generator
// ====================================
//
// TODO -me- lt's write an handler which catch the
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


// TODO -2-  use handleIntConverting and throw an IllegalArgumentException
// TODO      write the assert statement before u implement
val test3: Int = handleIntConverting {throw new IllegalArgumentException}
assert(test3 == -1)


// TODO -3-  use handleIntConverting and throw an IndexOutOfBoundsException
// TODO      write the assert statement before u implement
val test4: Int = handleIntConverting {
  "42".toInt
  throw new IndexOutOfBoundsException
}


