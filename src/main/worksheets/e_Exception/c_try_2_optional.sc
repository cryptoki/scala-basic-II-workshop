import scala.util.{Try, Success, Failure}

val list = Seq("3", "mal", "4", "is", "gleich", "12")

// TODO -1-  convert Strings into Int with Try
def convert(list: Seq[String]): Seq[Try[Int]] = ???
// what should be the result of the convert method?
val resultConvert = convert(list)


// TODO -2-  sum up every number in 'resultConvert'
def sum(list: Seq[Try[Int]]): Int = ???

val resultSum = sum(resultConvert)
assert(resultSum==19)


// TODO -3-  return a Int Sequence only with the natural numbers
def onlyNumbers(list: Seq[Try[Int]]): Seq[Int] = ???

val resultOnlyNumbers = onlyNumbers(resultConvert)
assert(resultOnlyNumbers == Seq(3,4,12))


// TODO -4-  result of number * 2 + 1 for every failure?
//           3*2 + 1 + 4*2 + 1 + 1 + 12*2
def sumNumber2AndAddFailure(list: Seq[Try[Int]]): Int = ???

val resultSumNumber2AndAddFailure = sumNumber2AndAddFailure(resultConvert)
assert(resultSumNumber2AndAddFailure == 41)




