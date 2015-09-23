/**
 * A partial function in mathematics is only defined for a subset of the possible
 * values of its arguments.
 *
 * https://en.wikipedia.org/wiki/Partial_function
 */
// TODO: fraction

/**
 * Scala supports definition of partial functions by a special type [[PartialFunction]]
 */
object Routes extends PartialFunction[String, String] {
  override def isDefinedAt(route: String): Boolean = ???

  override def apply(route: String): String = ???
}

// TODO: application of Routes
// TODO: Audience: What happens...
// Routes("/alive")


// syntactic sugar
val routes: PartialFunction[String, String] = ???

/**
 * Partial functions can be used everywhere a function is expected
 */
// TODO: Audience what would you expect?
//List("/alive", "/status", "/hello", "/search") map routes

// TODO: Audience what would you expect?
//List("/alive", "/status", "/hello", "/search") collect routes


