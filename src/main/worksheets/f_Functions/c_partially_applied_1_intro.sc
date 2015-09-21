/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int, z: Int) = x + y + z

val sumPartially = sum(1, _: Int, 3)

sumPartially(2)

/**
 * It's also possible to leave out a complete parameter list
 */
val sum2 = sum _

sum2(1, 2, 3)

/**
 * The underscore can be omitted when the compiler knows
 * that a function is expected
 */
val sum3: (Int, Int, Int) => Int = sum

/**
 * The compiler generates a class for the partially applied function
 * which wraps a call to the original function.
 */
class SumPartially extends Function1[Int, Int] {
  override def apply(a: Int): Int = sum(1, a, 3)
}