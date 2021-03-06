/**
 * Use case: Filter a list of strings with a set of predicates
 */
val hellos = List("", "H", "He", "Hel", "Hell", "Hello", "Hello ", "Hello W", "Hello Wo", "Hello Wor", "Hello Worl", "Hello World")

def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

def min(minimum: Int): String => Boolean = s => s.length >= minimum
def max(maximum: Int): String => Boolean = s => s.length <= maximum

/**
 * A function which returns a function which returns true if all predicates return true
 */
// TODO: all for predicates

/**
 * Define a (partial applied function) allMin1Max5 which can be used to filter the hellos list
 * and only leave strings in that list for which  1 <= s.length <= 5
 */
// TODO: allMin1Max5

// TODO: hellos.filter(allMin1Max5) == List("H", "He", "Hel", "Hell", "Hello")