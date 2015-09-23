// TODO -1-  please implement the method
/**
 * The product from all natural positive numbers, beginning from one to the
 * given maximum number.
 *
 * 4 Factorial or 4! = the product from 1, 2, 3 and 4 = 24.
 */
def factorial(n: Int): Int = {
  if (n == 0)
    1
  else
    n * factorial(n - 1)
}
val result: Int = factorial(4)
assert(result == 24)

// in IDEA recursion is marked by a mirror inverted
// @ symbol,
// in the worksheet left beside the method definition.
