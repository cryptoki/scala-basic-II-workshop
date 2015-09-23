/**
 * Scala doesn't know static members but supports definition of singleton objects.
 */
object AStandaloneObject {
  def apply() = {
    "Syntactic sugar: apply() is called"
  }

  def aMethod() = {
    "Hi"
  }
}

AStandaloneObject()
AStandaloneObject.aMethod()
AStandaloneObject.isInstanceOf[AnyRef]

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
  def revealSecret() = new Foo("").secret

  // Companion objects are often used as factories
  def apply(s: String) = new Foo(s)

  // or to define implicit conversions and other implicit stuff
  implicit def str(f: Foo): String = s"This is my foo:  ${f.foo}"
}

Foo.revealSecret()

// syntactic sugar: no new required
val newFoo = Foo("Bar").foo

// Implicit type conversion in action
val newFooString: String = new Foo("Implicit conversion")