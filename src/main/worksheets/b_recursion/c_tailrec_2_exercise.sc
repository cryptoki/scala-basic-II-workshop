// normal recursion
def factorialRecursion(n: Long): Long =
  if (n == 0)
    1
  else
    n * factorialRecursion(n - 1)
assert(factorialRecursion(4) == 24)

// TODO -1-  implement a tail recursion for factorial
def factorialTailRecursion(n: Long, acc: Long): Long = ???
assert(factorialTailRecursion(4, 1) == 24)


// TODO -2-  implement a tail recursion with only one parameter
def factorialTailRecursion(n: Long): Long = ???
assert(factorialTailRecursion(4) == 24)
