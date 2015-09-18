/**
 * Function defined via def
 */
def double(x: Int): Int = x * 2
double(3)

/**
 * A method is a function
 */
object FunctionWrapper {
  def square(x: Int): Int = x * x
}

FunctionWrapper.square(3)

/**
 * Local function
 */
def multipleSum(multiple: Int, x: Int, y: Int) = {
  def sum() = {
    x + y
  }
  multiple * sum()
}

multipleSum(3, 2, 2)

FunctionWrapper.square _ andThen double