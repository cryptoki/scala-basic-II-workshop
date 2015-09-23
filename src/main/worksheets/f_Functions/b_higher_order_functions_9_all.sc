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

acceptString("Hello World", seq => seq.length > 1)
acceptString("Hello World", seq => seq.length < 5)

/**
 * Functions can be return values.
 */
def minLength(min: Int): String => Boolean = (s: String) => s.length >= min
def maxLength(max: Int): String => Boolean = (s: String) => s.length <= max

acceptString("Foo", minLength(1))
acceptString("Bar", maxLength(2))

// TODO Audience: Write a function literal which does the same as minLength
val minLiteral: (Int) => (String => Boolean) = (minimum) => (s => s.length >= minimum)
// val minLiteral2 = (minimum: Int) => ((s: String) => s.length >= minimum)
// variant: val minLiteral = (minimum: Int) => (s: String) => s.length >= minimum

acceptString("Foo", minLiteral(1))

// Lost in parameter type lists? Type aliases to the rescue!
type Predicate = String => Boolean

val hasLength: Int => Predicate = i => s => s.length == i

acceptString("FooBar", hasLength(6))

