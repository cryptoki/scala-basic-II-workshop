/**
 * "Currying is the technique of translating the evaluation of a function that takes
 * multiple arguments (or a tuple of arguments) into evaluating a sequence of functions,
 * each with a single argument (partial application)"
 *
 * https://en.wikipedia.org/wiki/Currying
 */

def sum(x: Int, y: Int) = x + y
// TODO: sumCurried

// without currying
def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

acceptString("Hello World", seq => seq.length > 1)
acceptString("Hello World", seq => seq.length < 100)

/**
 * Currying enables definition of functions which look more like built-in language constructs
 */
// TODO: acceptStringCurried

// Play framework example:
// https://www.playframework.com/documentation/2.4.3/ScalaBodyParsers#Specifying-a-body-parser
