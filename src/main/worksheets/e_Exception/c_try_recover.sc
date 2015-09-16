import scala.util.Try

def divideBy(input: Int, divisor: Int) : Try[Int] = {
  Try(input / divisor)
}

// TODO -1-  What happend with  'divideBy(10, 0)'?
val result1 = ???


// TODO -2-  use recover to return -1 if Failure


// TODO -3-  use recoverWith to "try" another divideBy
