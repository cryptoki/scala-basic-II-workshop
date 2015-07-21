import scala.util.{Failure, Success, Try}

def parseInt(s: String) : Try[Int] = Try(s.toInt)

parseInt("10")
val result = parseInt("test")

result match {
  case Success(i) => println(s"yeah $i")
  case Failure(e) => println(s"buuuh ${e.getMessage}")
}

result.getOrElse(0)
//result.get -> only for testing

parseInt("40").map(_*2)

def divideBy(input: Int, divisor: Int) : Try[Int] = Try(input / divisor)

divideBy(10, 0)

parseInt("34").flatMap { input =>
  parseInt("4").flatMap { divide =>
    divideBy(input, divide)
  }
}

val result3 = for {
  input <- parseInt("34")
  divide <- parseInt("3")
  r <- divideBy(input, divide)
} yield r
result3

divideBy(3,0).recover({
  case e: ArithmeticException => -1
})
divideBy(3,0).recoverWith({
  case e: ArithmeticException => divideBy(3,1)
})