/**
 * How to handle multiple traits defining methods with same signature?
 */
trait A {
  def foo = "A"
}

trait B {
  def foo = "B"
}

class C

// Audience: What happens?
val c = new C() with A with B {
  override def foo = super[A].foo
}
c.foo
