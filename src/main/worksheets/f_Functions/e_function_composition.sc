// Function
// audience
val double: Int => Int = _ * 2
val triple: Int => Int = _ + 3

(double andThen triple)(3)

Function.chain(Seq(double, triple))(3)

(double compose triple)(3)




// PartialFunction

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
  case 500 => "Just panic"
}

def processResponse(status: Int, handler: Int => String): String = handler(status)

processResponse(200, okHandler orElse errorHandler)
processResponse(500, okHandler orElse errorHandler)
processResponse(5, okHandler orElse errorHandler)