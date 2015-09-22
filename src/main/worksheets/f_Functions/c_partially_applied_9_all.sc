/**
 * A partially applied function is an expression where you supply only some or none
 * of the arguments to a function
 */
def sumOfThree(x: Int, y: Int, z: Int) = x + y + z

val sumPartially = sumOfThree(1, _: Int, 3)

sumPartially(2)

/**
 * The compiler generates a class for the partially applied function
 * which wraps a call to the original function.
 */
class SumPartially extends Function1[Int, Int] {
  override def apply(a: Int): Int = sumOfThree(1, a, 3)
}

new SumPartially()(3)

/**
 * Use case: Improve the higher order functions example
 */
def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

def min(minimum: Int): String => Boolean = (s: String) => s.length >= minimum
def max(maximum: Int): String => Boolean = (s: String) => s.length <= maximum

/**
 * A function which applies a list of predicates to a string.
 */
def any(predicates: (String => Boolean)*): String => Boolean =
  s => predicates.forall(pred => pred(s))

/**
 * Audience: Define a partial applied function minMax for which the predicates are fixed
 */
val minMax = acceptString(_: String, any(min(1), max(5)))

val hellos = List("", "H", "He", "Hel", "Hell", "Hello", "Hello ", "Hello W", "Hello Wo", "Hello Wor", "Hello Worl", "Hello World")

assert(hellos.filter(minMax) == List("H", "He", "Hel", "Hell", "Hello"))

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

/**
 * Named functions, methods and local functions can't be used as arguments
 * or assigned to a val (in all cases).
 */
object Math {
  def square(x: Int) = x * x

  val sum = (x: Int, y: Int) => x + y
}

val sumRef = Math.sum


// Audience: This does not work. How to fix?
//val squareRef = Math.square
