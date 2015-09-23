import scala.util.{Try, Success, Failure}

// TODO -1-  implement an exception handling without
//           try/catch clause use the Try class
// TODO -me-  show method signature call by name
val convert: Try[Int] = ???


// TODO -2-  implement match clause for 'convert'
// try is am abstract class, a sealed abstract class
// with two sub final case classes
//  1 - Success - contains the result
//  2 - Failure - contains the exception
val convertResult = ???



// TODO -me-  show few methods
// use of map/flatMap/transform/getOrElse
// => value *2 OR failure = -1
val a1 = ???
val a2 = ???
val a3 = ???
val a4 = ???



// ==> PUI (gateways PaymentApiClient, SemanticApiClient...)
