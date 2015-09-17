class A {
  val a = "Hello from A"
}

class B extends A

class C

trait D {
  self: A =>

  def d = a
}

new B() with D

// does not compile
// new B() with C