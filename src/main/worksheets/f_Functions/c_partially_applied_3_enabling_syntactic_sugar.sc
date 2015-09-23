/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int) = x + y

/**
 * It's also possible to leave out a complete parameter list
 */
// TODO: leave out parameter list

/**
 * The underscore can be omitted when the compiler knows
 * that a function is expected
 */
val sum3: (Int, Int) => Int = ???

/**
 * These are the basics for some syntactic sugar
 */
// TODO: syntactic sugar