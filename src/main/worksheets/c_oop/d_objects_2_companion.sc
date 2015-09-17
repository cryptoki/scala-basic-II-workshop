import scala.language.implicitConversions

/**
 * Companion objects are created in the same file like a class with the same name.
 *
 * A companion object can access private fields of its companion class and is often used
 * to define "implicits".
 */
class Foo(fooString: String) {
  private val secret = "I am a secret"

  val foo = fooString
}

object Foo {
  // A companion object can access private fields of its companion class
  def revealSecret() = new Foo("").secret

  // Companion objects are often used as factories
  def apply() = new Foo("Greetings from companion object")

  // or to define implicit conversions and other implicit stuff
  implicit def str(f: Foo): String = s"This is my foo:  ${f.foo}"
}

Foo.revealSecret()

// syntactic sugar: no new required
val newFoo = Foo().foo

// Implicit type conversion in action
val newFooString: String = new Foo("Implicit conversion")