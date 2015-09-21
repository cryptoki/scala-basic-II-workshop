import scala.annotation.tailrec

def sumNaturalNumbersImperative(maximum: Int) : Long = {
  var result: Long = 0
  for ( i <- 1 to maximum) {
    result += i
  }
  result
}
assert(sumNaturalNumbersImperative(55) == 1540)

def sumNaturalNumbersRecursive(maximum: Int) : Long = {
  if (maximum == 0)
    0l
  else
    maximum + sumNaturalNumbersRecursive(maximum - 1)
}
assert(sumNaturalNumbersRecursive(55) == 1540)

def sumNaturalNumbersTailRecursive(maximum: Int) : Long = {
  @tailrec
  def sumNaturalNumbersTailRecursive(maximum: Int, acc: Long) : Long = {
    if (maximum == 0)
      acc
    else
      sumNaturalNumbersTailRecursive(maximum - 1, acc + maximum)
  }
  sumNaturalNumbersTailRecursive(maximum, 0)
}
assert(sumNaturalNumbersTailRecursive(55) == 1540)
