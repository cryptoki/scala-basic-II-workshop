/**
 * Functions can be composed in several ways
 */
val times2: Int => Int = _ * 2
val plus3: Int => Int = _ + 3


// TODO: andThen

// TODO: chain

// TODO: compose

/**
 * In addition, PartialFunctions can be composed via [[PartialFunction.orElse]]
 */
val okHandler: PartialFunction[Int, String] = {
  case 200 => "Do some cool stuff"
}

val unauthorizedHandler: PartialFunction[Int, String] = {
  case 401 => "Login again"
}

val paymentRequiredHandler: PartialFunction[Int, String] = {
  case 402 => "Pay the bills"
}

val errorHandler: PartialFunction[Int, String] = {
  case 500 => "Server Error"
}

val unknownHandler: PartialFunction[Int, String] = {
  case _ => "Just panic"
}

def processResponse(status: Int, handler: Int => String): String = handler(status)

// TODO: orElse

// Audience: What would you expect
// TODO: processResponse(5, okHandler orElse errorHandler )