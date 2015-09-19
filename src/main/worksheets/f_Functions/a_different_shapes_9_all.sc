/**
 * Function defined via def
 */
def double(x: Int) = x * 2
double(3)

/**
 * A method is a function
 */
object FunctionWrapper {
  def square(x: Int) = x * x
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


/**
 * First-class functions: A function literal
 *
 * aka anonymous function, lambda expression
 */
val sumFunctionLiteral = (x: Int, y: Int) => x + y
sumFunctionLiteral(2, 3)

/**
 * The compiler generates a class for a function literal
 */
class SumClass extends Function2[Int, Int, Int] {
  override def apply(x: Int, y: Int) = x + y
}

/**
 * Instances of the generated classes are function value objects
 */
val sumFunctionValueObject = new SumClass
sumFunctionValueObject(2, 3)

/**
 * Why not creating function value objects...
 */
object objectSum extends Function3[Int, Int, Int, Int] {
  override def apply(x: Int, y: Int, z: Int): Int = x + y + z
}

objectSum(1, 2, 3)