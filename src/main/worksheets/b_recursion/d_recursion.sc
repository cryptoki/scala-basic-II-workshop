import scala.annotation.tailrec

// imperative
def factorialImperative(n: Long): Long = {
  var result: Long = 1
  for (i: Long <- 1l to n)
    result *= i
  result
}
factorialImperative(4)

// normal recursion
def factorialRecursion(n: Long): Long =
  if (n == 0)
    1
  else
    n * factorialRecursion(n - 1)
factorialRecursion(4)

// tail recursion
def factorialTailRecursion(n: Long, acc: Long): Long =
  if (n == 0)
    acc
  else
    factorialTailRecursion(n - 1, acc * n)
factorialTailRecursion(4, 1)

// tail recursion with inner method and annotation
def factorialTailRecursion(n: Long): Long = {
  // to use the tailrec annotation you have to import scala.annotation.tailrec
  @tailrec
  def factorialTailRecursion(n: Long, acc: Long): Long =
    if (n == 0)
      acc
    else
      factorialTailRecursion(n - 1, acc * n)

  factorialTailRecursion(n, 1)
}
factorialTailRecursion(4)
