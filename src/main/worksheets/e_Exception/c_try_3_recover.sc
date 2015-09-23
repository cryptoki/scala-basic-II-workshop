import scala.util.{Success, Try}

def divideBy(input: Int, divisor: Int) : Try[Int] = {
  Try(input / divisor)
}

// TODO -1-  What is the result of  'divideBy(10, 0)'?
val result1: Try[Int] = ???


// TODO -2-  use recover to return -1 if Failure


// TODO -3-  use recoverWith to "try" another divideBy



// ==> PUI (DownloadFromBlobRocket...)