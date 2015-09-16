import scala.util.{Try, Success, Failure}

// Intro
// =====
// the old known Int converter
val convert: Try[Int] = Try { "abc".toInt }

// try is am abstract class, a sealed abstract class
// with two sub final case classes
//  1 - Success - contains the result
//  2 - Failure - contains the exception
convert match {
  case Success(result) => println(s"Yipee $result")
  case Failure(exc) => println(s"Buhh $exc")
}

// use of map/flatMap/transform/getOrElse
val a1 = convert.flatMap(x => Success(3))
val a2 = convert.transform(x => Success(x+1), e => Success(2))
val a3 = convert.map(x => x+1)
val a4 = convert.getOrElse(42)




// work with monad functions
// =========================

val list = Seq("3", "mal", "4", "is", "gleich", "12")

// TODO -1- convert Strings into Int with Try
def convert(list: Seq[String]): Seq[Try[Int]] = list.map(x => Try(x.toInt))

// TODO -2- sum up every number
def sum(list: Seq[Try[Int]]): Int = list.map(x => x.getOrElse(0)).sum

// TODO -3- return a Int Sequence only with the natural numbers
def onlyNumbers(list: Seq[Try[Int]]): Seq[Int] = list.filter(x => x.isSuccess).map(x => x.get)

// TODO -4- number * 2 + 1 for every failure
// TODO     3*2 + 1 + 4*2 + 1 + 1 + 12*2
def sumNumber2AndAddFailure(list: Seq[Try[Int]]): Int =
  sum(list.map(x => x.transform(x => Success(x*2), e => Success(1))))

// Test
// ====
val resultConvert = convert(list)

val resultSum = sum(resultConvert)
assert(resultSum==19)

val resultOnlyNumbers = onlyNumbers(resultConvert)
assert(resultOnlyNumbers == Seq(3,4,12))

val resultSumNumber2AndAddFailure = sumNumber2AndAddFailure(resultConvert)
assert(resultSumNumber2AndAddFailure == 41)


// Recover
// =======
import scala.util.Try

def divideBy(input: Int, divisor: Int) : Try[Int] = {
  Try(input / divisor)
}

val result1 = divideBy(10, 0)


divideBy(3,0).recover({
  case e: ArithmeticException => -1
})
divideBy(3,0).recoverWith({
  case e: ArithmeticException => divideBy(3,1)
})