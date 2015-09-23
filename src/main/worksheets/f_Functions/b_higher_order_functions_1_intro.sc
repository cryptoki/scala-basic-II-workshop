/**
 * Function value objects can be passed as arguments to build Higher Order Functions
 *
 * Higher Order Functions do at least one of the following:
 * - take one or more functions as an input
 * - output a function
 * - do both
 *
 * https://en.wikipedia.org/wiki/Higher-order_function
 *
 * Examples: map, filter, reduce ...
 */
def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)
// TODO: 2 variants of acceptString with predicates

/**
 * Functions can be return values.
 */
def minLength(min: Int): String => Boolean = ???
def maxLength(max: Int): String => Boolean = ???

acceptString("Foo", minLength(1))
acceptString("Bar", maxLength(2))