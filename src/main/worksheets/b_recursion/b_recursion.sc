// corresponding test
// ==================
// b_recursion/a_SumNaturalNumbers

/**
 * Factorial
 * =========
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
// in IDEA is recursion marked be a mirror inverted @ symbol, in the worksheet
// left beside the method definition.

// 4 * factorial(3)
// 3 * factorial(2)
// 2 * factorial(1)
// 1 * factorial(0)
// 1

// = 1
// = 1
// = 2
// = 6
// = 24

/**
 * simple recursive way, but there is a problem.
 *
 * the result of every recursion step needs to saved. if the depth is to high, a
 * StackOverflowError occurs. The program will terminate.
 */
def problem(n: Long): Long = {
  if (n == 0)
    0
  else
    n + (problem(n - 1) - (n/2))
}
problem(300)
// StackOverflow
problem(30000)

// In the factorial example you can see every step, at the end the result will be
// recursively calculate from every saved step


// Please implement the a_SumNaturalNumbersTest in a recursive manner
