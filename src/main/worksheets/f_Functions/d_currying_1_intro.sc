/**
 * "Currying is the technique of translating the evaluation of a function that takes
 * multiple arguments (or a tuple of arguments) into evaluating a sequence of functions,
 * each with a single argument (partial application)"
 *
 * https://en.wikipedia.org/wiki/Currying
 */

def sum(x: Int, y: Int) = x + y
def sumCurried(x: Int)(y: Int) = x + y

def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

acceptString("Hello World", seq => seq.length > 1)
acceptString("Hello World", seq => seq.length < 100)

/**
 * Enables definition of functions which look more like built-in language constructs
 */
def acceptStringCurried(s: String)(pred: String => Boolean): Boolean = pred(s)

acceptStringCurried("Hello World") {
  seq => seq.length > 1
}

acceptStringCurried("Hello World") {
  seq => seq.length < 100
}

