/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int, z: Int) = x + y + z

val sumPartially = sum(1, _: Int, 3)

sumPartially(2)

/**
 * The compiler generates a class for the partially applied function
 * which wraps a call to the original function.
 */
class SumPartially extends Function1[Int, Int] {
  override def apply(a: Int): Int = sum(1, a, 3)
}

new SumPartially()(3)