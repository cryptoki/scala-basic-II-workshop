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

/**
 * Curried functions enable compiler for type inference
 */
def acceptCurried[T](something: T)(pred: T => Boolean): Boolean = pred(something)


// types in predicate function can be omitted
acceptCurried("Curry")(s => s.length > 0)
acceptCurried("Curry")(_.length > 0)
acceptCurried(15)(i => i > 0)
acceptCurried(15)(_ > 0)


// Type inference is not possible in uncurried version
def accept[T](s: T, pred: T => Boolean): Boolean = pred(s)

accept("Curry", (s: String) => s.length > 0)
accept(15, (i: Int) => i > 0)

// without currying this is not possible:
//accept("Curry", s => s.length > 0)
//accept("Curry", _.length > 0)
//accept(15)(i => i > 0)
//accept(15)(_ > 0)

/**
 * Currying must be used when working with implicit parameter lists.
 *
 * Implicit parameter lists are frequently used to inject dependencies into functions.
 */
def accept(s: String)(implicit pred: String => Boolean): Boolean = pred(s)

implicit val isOink: String => Boolean = s => s == "Oink"

accept("Yeeha")
accept("Oink")

// Show Example code from Play framework project with implicit request