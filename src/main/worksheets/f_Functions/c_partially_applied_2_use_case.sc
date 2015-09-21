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