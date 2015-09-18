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
acceptString("Hello World", seq => seq.length < 100)

/**
 * Want to be more flexible? Functions can be return values.
 */
def min(minimum: Int): String => Boolean = (s: String) => s.length >= minimum
def max(maximum: Int): String => Boolean = (s: String) => s.length <= maximum


acceptString("Foo", min(1))
acceptString("Bar", max(2))

// min and max can be written as
val minLiteral: Int => String => Boolean = minimum => s => s.length >= minimum
val maxLiteral: Int => String => Boolean = maximum => s => s.length <= maximum

acceptString("Foo", minLiteral(1))
