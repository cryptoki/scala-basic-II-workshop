import scala.language.implicitConversions

/**
 * Companion objects are created in the same file like a class with the same name.
 *
 * A companion object can access private fields of its companion class and is often used
 * to define "implicits".
 */
class Foo(s: String) {
  private val secret = "I am a secret"

  val foo = s
}

object Foo {
  // A companion object can access private fields of its companion class
  def revealSecret() = ???

  // Companion objects are often used as factories
  def apply(s: String) = ???

  // or to define implicit conversions and other implicit stuff
  // TODO: implicit conversion
}

Foo.revealSecret()

// syntactic sugar: no new required
// TODO: instance via factory

// Implicit type conversion in action
// TODO: implicit conversion