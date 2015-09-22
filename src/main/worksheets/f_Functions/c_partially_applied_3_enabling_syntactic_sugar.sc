/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int) = x + y

/**
 * It's also possible to leave out a complete parameter list
 */
val sum2 = sum _

sum2(1, 2)

/**
 * The underscore can be omitted when the compiler knows
 * that a function is expected
 */
val sum3: (Int, Int) => Int = sum
sum3(1, 2)

/**
 * These are the basics for some syntactic sugar
 */
1 to 100 reduce ((x, y) => sum(x, y))
1 to 100 reduce (sum(_, _))
1 to 100 reduce (sum)
1 to 100 reduce sum
