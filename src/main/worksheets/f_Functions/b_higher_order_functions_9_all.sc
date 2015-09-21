/**
 * Function value objects can be passed as arguments to build Higher Order Functions
 *
 * Higher Order Functions do at least one of the following:
 * - take one or more functions as an input
 * - output a function
 * - do both
 *
 * https://en.wikipedia.org/wiki/Higher-order_function
 */
def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

acceptString("Hello World", seq => seq.length > 1)
acceptString("Hello World", seq => seq.length < 5)

/**
 * Want to be more flexible? Functions can be return values.
 */
def minLength(min: Int): String => Boolean = (s: String) => s.length >= min
def maxLength(max: Int): String => Boolean = (s: String) => s.length <= max

acceptString("Foo", minLength(1))
acceptString("Bar", maxLength(2))

// TODO Audience: How to write minLength and maxLength as function literals?
// hint: look at different implementations of sum to have examples
val sum1 = (x: Int, y: Int) => x + y
val sum2: (Int, Int) => Int = (x, y) => x + y

val minLiteral: Int => String => Boolean = minimum => s => s.length >= minimum
// variant: val minLiteral = (minimum: Int) => (s: String) => s.length >= minimum
val maxLiteral: Int => String => Boolean = maximum => s => s.length <= maximum
// variant: val maxLiteral = (max: Int) => (s: String) => s.length <= max

acceptString("Foo", minLiteral(1))
acceptString("Foo", maxLiteral(2))
