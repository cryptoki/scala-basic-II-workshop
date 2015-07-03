import scala.annotation.tailrec

// imperative
def factorialImperative(n: Long): Long = {
  var result = 0
  for (i <- 1l to n)
    result += i
  result
}

// normal recursion
def factorialRecursion(n: Long): Long =
  if (n == 0)
    1
  else
    n * factorialRecursion(n - 1)

// tail recursion
def factorialTailRecursion(n: Long, acc: Long): Long =
  if (n == 0)
    1
  else
    factorialTailRecursion(n - 1, acc * n)

// tail recursion with inner method and annotation
def factorialTailRecursion(n: Long): Long = {
  // to use the tailrec annotation you have to import scala.annotation.tailrec
  @tailrec
  def factorialTailRecursion(n: Long, acc: Long): Long =
    if (n == 0)
      1
    else
      factorialTailRecursion(n - 1, acc * n)

  factorialTailRecursion(n, 1)
}
