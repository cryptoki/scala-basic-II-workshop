// there is no static in Scala, Scala is object oriented and thus has singleton objects

object AStandaloneObject {
  def apply() = {
    "Syntactic sugar: apply() is called"
  }

  def aMethod() = {
    "I am static"
  }
}

AStandaloneObject()
AStandaloneObject.aMethod()
AStandaloneObject.isInstanceOf[AnyRef]


// companion object: object created in the same file like a class with the same name
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
