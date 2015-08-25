/**
 * Scala doesn't support static members but supports definition of singleton objects.
 *
 */
object AStandaloneObject {
  def apply() = {
    "Syntactic sugar: apply() is called"
  }

  def aMethod() = {
    "Hi there"
  }
}

AStandaloneObject()
AStandaloneObject.aMethod()
AStandaloneObject.isInstanceOf[AnyRef]


/**
 * Companion objects are created in the same file like a class with the same name.
 *
 * A companion object can access private fields of its companion class and is often used
 * to define "implicits".
 */
class Foo {
  private val secret = "I am a secret"
}

object Foo {
  def revealSecret() = {
    new Foo().secret
  }
}

Foo.revealSecret()

// Type of a companion object is its companion class


// object can extend and mixin
trait Mixin

object Bar extends Foo with Mixin
