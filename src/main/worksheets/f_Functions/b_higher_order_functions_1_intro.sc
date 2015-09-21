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