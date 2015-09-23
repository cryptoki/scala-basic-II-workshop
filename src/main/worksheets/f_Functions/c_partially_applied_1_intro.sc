/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int, z: Int) = x + y + z

val sumPartially = ???

/**
 * The compiler generates a class for the partially applied function
 * which wraps a call to the original function.
 */
// TODO: class SumPartially