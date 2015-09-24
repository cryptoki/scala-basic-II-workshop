// ====================================
// factorial
// ====================================

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
factorial(4)

// in IDEA recursion is marked by a mirror inverted @ symbol, in the worksheet
// left beside the method definition.

// ====================================
// Problem
// ====================================

/**
 * simple recursive way, but there is a problem.
 * the result of every recursion step needs to saved.
 * if the depth is to high, a StackOverflowError
 * occurs. The program will terminate.
 */
// TODO -me-  write a simple sum example
def overflowingSum(n: Long): Long = {
  if (n == 0)
    0
  else
    n + (overflowingSum(n - 1) - (n/2))
}
overflowingSum(300)
// StackOverflow
overflowingSum(30000)

// In the factorial example you can see every step,
// at the end the result will be
// recursively calculate from every saved step
