/* partial function is a function which can be defined for a
 * subset of possible values of its arguments
 * support in Scala with PartialFunction class */


// TODO -me-  extends from PartialFunction and implement
//            NumberFormatException
object NumberFormatExceptionHandler
// assert(NumberFormatExceptionHandler.isDefinedAt(new NumberFormatException) == true)
// assert(NumberFormatExceptionHandler.isDefinedAt(new IndexOutOfBoundsException) == false)


// TODO -me-  synatic sugar
/*            NumberFormatException and return -1
 *            IndexOutOfBoundsException */
val handler: PartialFunction[Throwable, Int] = ???

assert(handler.isDefinedAt(new IndexOutOfBoundsException) == true)
assert(handler.isDefinedAt(new NumberFormatException) == true)


// TODO -me-  apply NumberFormatException
val result1 = ???
// TODO -me-  lift IllegalArgumentException
val result2 = ???
