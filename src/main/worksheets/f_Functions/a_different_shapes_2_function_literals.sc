/**
 * First-class functions: A function literal
 *
 * aka anonymous function, lambda expression
 */
val sum: (Int, Int) => Int = (x, y) => x + y
sum(2, 3)

val square = (x: Int, y: Int) => x * y

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
 * Audience: Create a function object which calculates the sum of 3 elements
 */
object SumOfThree extends Function3[Int, Int, Int, Int] {
  override def apply(x: Int, y: Int, z: Int): Int = x + y + z
}

SumOfThree(1, 2, 3)
