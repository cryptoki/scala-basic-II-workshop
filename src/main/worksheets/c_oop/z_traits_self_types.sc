class A {
  val a = "Hello from A"
}

class B extends A

class C

/**
 * On the one hand, self reference in traits is used to access "this".
 *
 * A typed self reference ensures that a trait can only be mixed into an instance of
 * the type of the self reference.
 */
trait D {
  self: A =>

  def d = a
}

new B() with D

// does not compile
// new B() with C