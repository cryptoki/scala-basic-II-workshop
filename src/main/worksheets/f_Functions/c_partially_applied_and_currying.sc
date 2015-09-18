/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sum(x: Int, y: Int, z: Int) = x + y + z

val sumPartially = sum(1, _: Int, 3)

sumPartially(2)

/**
 * It's also possible to leave out a complete parameter list
 */
val sum2 = sum _

sum2(1, 2, 3)

/**
 * The compiler generates a class for the partially applied function
 * which wraps a call to the original function.
 */
class SumPartially extends Function1[Int, Int] {
  override def apply(a: Int): Int = sum(1, a, 3)
}

/**
 * Usage: Improve the higher order functions example
 */
def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

def min(minimum: Int): String => Boolean = (s: String) => s.length >= minimum
def max(maximum: Int): String => Boolean = (s: String) => s.length <= maximum

def any(predicates: (String => Boolean)*): String => Boolean =
  s => predicates.forall(pred => pred(s))

val minMax = acceptString(_: String, any(min(1), max(5)))

minMax("Hello")
minMax("Hello World")
val hellos = List("", "H", "He", "Hel", "Hell", "Hello", "Hello ", "Hello W", "Hello Wo", "Hello Wor", "Hello Worl", "Hello World")
hellos.filter(minMax)

/**
 * FYI: Functions defined with def, methods and local functions can't be used as arguments
 * or assigned to a val.
 */
def square(x: Int): Int = x * x

// does not work: val s = square

// function wrapping can be used as workaround
val a = square _
a(3)

// when a complete parameter list is replaced by underscore,
// the underscore can be omitted when the compiler knows that
// a function is needed
val b: Int => Int = square
b(4)