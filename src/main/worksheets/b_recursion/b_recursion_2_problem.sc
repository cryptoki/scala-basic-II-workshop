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

// TODO -1-  call the method with different values
//           which problem can be occur?