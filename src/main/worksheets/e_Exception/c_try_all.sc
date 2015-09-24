import scala.util.{Try, Success, Failure}

// Intro
// =====
// TODO -1-  implement an exception handling without
//           try/catch clause use the Try class
// TODO -me-  show method signature call by name
// the old known Int converter
val convert: Try[Int] = Try { "abc".toInt }
Try.apply("abc".toInt)

// TODO -2-  implement match clause for 'convert'
// try is am abstract class, a sealed abstract class
// with two sub final case classes
//  1 - Success - contains the result
//  2 - Failure - contains the exception
val convertResult = convert match {
  case Success(result) => println(s"Yipee $result")
  case Failure(exc) => println(s"Buhh $exc")
}

// TODO -me-  show few methods
// use of map/flatMap/transform/getOrElse
// => value *2 OR failure = -1
val a1 = convert.flatMap(x => Success(x*2))
val a2 = convert.transform(x => Success(x*1), e => Success(-1))
val a3 = convert.map(x => x*2)
val a4 = convert.getOrElse(-1)


// ==> PUI (gateways PaymentApiClient, SemanticApiClient...)


// ====================================
// optional
// ====================================

// work with monad functions
// =========================

val list = Seq("3", "mal", "4", "is", "gleich", "12")

// TODO -1-  convert Strings into Int with Try
def convert(list: Seq[String]): Seq[Try[Int]] = list.map(x => Try(x.toInt))
// what should be the result of the convert method?
val resultConvert = convert(list)


// TODO -2-  return a Int Sequence only with the natural numbers
def onlyNumbers(list: Seq[Try[Int]]): Seq[Int] =
  list.filter(x => x.isSuccess).map(x => x.get)

val resultOnlyNumbers = onlyNumbers(resultConvert)
assert(resultOnlyNumbers == Seq(3,4,12))


// TODO -3-  sum up every number in 'resultConvert'
def sum(list: Seq[Try[Int]]): Int =
  list.map(x => x.getOrElse(0)).sum

val resultSum = sum(resultConvert)
assert(resultSum==19)


// TODO -4-  result of number * 2 + 1 for every failure?
//           3*2 + 1 + 4*2 + 1 + 1 + 12*2
def sumNumber2AndAddFailure(list: Seq[Try[Int]]): Int =
  sum(list.map(x => x.transform(x => Success(x*2), e => Success(1))))

val resultSumNumber2AndAddFailure = sumNumber2AndAddFailure(resultConvert)
assert(resultSumNumber2AndAddFailure == 41)



// ====================================
// Recover
// ====================================

import scala.util.Try

def divideBy(input: Int, divisor: Int) : Try[Int] = {
  Try(input / divisor)
}

// TODO -1-  What is the result of  'divideBy(10, 0)'?
val result1: Try[Int] = divideBy(10, 0)


// TODO -2-  use recover to return -1 if Failure
divideBy(3,0).recover({
  case e: ArithmeticException => -1
})


// TODO -3-  use recoverWith to "try" another divideBy
divideBy(3,0).recoverWith({
  case e: ArithmeticException => divideBy(3,1)
})

// ==> PUI (DownloadFromBlobRocket...)