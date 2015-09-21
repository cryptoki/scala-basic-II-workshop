/**
 * Named Function
 */
def double(x: Int): Int = x * 2
double(3)

/**
 * A method is a function
 */
object Math {
  def square(x: Int): Int = x * x
}

Math.square(3)

/**
 * Local function
 */
def multipleSum(m: Int, x: Int, y: Int) = {
  def sum() = {
    x + y
  }
  m * sum()
}

multipleSum(3, 2, 2)
