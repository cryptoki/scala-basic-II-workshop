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
