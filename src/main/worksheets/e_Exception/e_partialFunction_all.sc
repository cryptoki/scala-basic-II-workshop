/* partial function is a function which can be defined for a
 * subset of possible values of its arguments */

/**
 * PartialFunction in Scala PartialFunction Class
 *  1 =>  Sub Trait von Function1
 *    - isDefindedAt
 *    - lift
 */

// ====================================
// Intro
// ====================================

// TODO -me-  extends from PartialFunction and implement
//            NumberFormatException
object NumberFormatExceptionHandler extends PartialFunction[Throwable, Int] {
  override def isDefinedAt(x: Throwable): Boolean = x.isInstanceOf[NumberFormatException]

  override def apply(v1: Throwable): Int = v1 match {
    case v1: NumberFormatException => -1
  }
}
assert(NumberFormatExceptionHandler.isDefinedAt(new NumberFormatException) == true)
assert(NumberFormatExceptionHandler.isDefinedAt(new IndexOutOfBoundsException) == false)


// TODO -me-  synatic sugar
/*            NumberFormatException and return -1
 *            IndexOutOfBoundsException */
val handler: PartialFunction[Throwable, Int] = {
  case n: NumberFormatException => {
    println("I catch u")
    -1
  }
  case i: IndexOutOfBoundsException => 0
}

assert(handler.isDefinedAt(new IndexOutOfBoundsException) == true)
assert(handler.isDefinedAt(new NumberFormatException) == true)


// TODO -me-  apply NumberFormatException
val result1 = handler.apply(new NumberFormatException("do not use!!!"))
// TODO -me-  lift IllegalArgumentException
val result2 = handler.lift(new IllegalArgumentException("do not use!!!"))


// ====================================
// try / Catch
// ====================================

val globalHandler: PartialFunction[Throwable, Int] = {
  case e:Throwable => {
    println(s"danger! '${e.getMessage}'")
    Int.MinValue
  }
}

// TODO -1-  use try and catch and both handler to
/*           a ) convert "abc".toInt
 *           b ) throw new NoSuchElementException("do not use! :)")
 *               use the globalHandler after the 'handler' */
try {
//  throw new NoSuchElementException("do not use! :)")
  "abc".toInt
}
catch handler.orElse(globalHandler)


// ====================================
// Project
// ====================================

// PUI open WSResponseProcessor
// and PaymentApiClient


// syntactic sugar
val dump: PartialFunction[Int, Int] = {
  case i if i % 2 == 0 => i + 1
}


/* Partial functions can be used everywhere a function
 * is expected */
// TODO -1-  What would you expect?
// 0 to 10 map dump

// TODO -2-  What would you expect?
// 0 to 10 collect dump

