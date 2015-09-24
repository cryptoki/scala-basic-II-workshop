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


