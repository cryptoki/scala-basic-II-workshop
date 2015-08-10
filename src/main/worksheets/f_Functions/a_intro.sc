import scala.annotation.tailrec

// functions are values

// useful to write a function that accepts other functions
// as arguments, this is called higher order functions (HOF)
def factorial(n: Int): Int = {
  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc else factorial(n - 1, n * acc)
  factorial(n, 1)
}

def formatResult(name: String, n: Int, f: Int => Int) = {
  val msg = "The %s of %d is %d."
  msg.format(name, n, f(n))
}

formatResult("Factorial", 10, factorial)