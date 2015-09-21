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

/**
 * First-class functions: A function literal
 *
 * aka anonymous function, lambda expression
 */
val sum = (x: Int, y: Int) => x + y
sum(2, 3)

/**
 * The compiler generates a class for a function literal which extends
 * one of the [[Function1]] traits
 */
class SumClass extends Function2[Int, Int, Int] {
  override def apply(x: Int, y: Int) = x + y
}

/**
 * Instances of the generated classes are function value objects
 */
val sumInstance = new SumClass
sumInstance(2, 3)

/**
 * Why not creating function value objects using...
 */
object sumOfThree extends Function3[Int, Int, Int, Int] {
  override def apply(x: Int, y: Int, z: Int): Int = x + y + z
}

sumOfThree(1, 2, 3)
