/**
 * A partial function in mathematics is only defined for a subset of the possible
 * values of its arguments.
 *
 * https://en.wikipedia.org/wiki/Partial_function
 */
def fraction(d: Int) = 42 / d

/**
 * Scala supports definition of partial functions by a special type [[PartialFunction]]
 */
object Routes extends PartialFunction[String, String] {
  override def isDefinedAt(route: String): Boolean = Seq("/hello", "/status") contains route

  override def apply(route: String): String = route match {
    case "/hello" => "Hello World"
    case "/status" => "Alive"
    case _ => "404"
  }
}

Routes("/hello")
Routes.isDefinedAt("/status")
Routes.isDefinedAt("/alive")

// Audience: What happens...
// Routes("/alive")


// syntactic sugar
val dump: PartialFunction[Int, Int] = {
  case i if i % 2 == 0 => i + 1
}

/**
 * Partial functions can be used everywhere a function is expected
 */
// Audience what would you expect?
// 0 to 10 map dump

// Audience what would you expect?
// 0 to 10 collect dump






