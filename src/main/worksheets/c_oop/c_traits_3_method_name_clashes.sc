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
// TODO: val c = new C() with A with B
//c.foo
