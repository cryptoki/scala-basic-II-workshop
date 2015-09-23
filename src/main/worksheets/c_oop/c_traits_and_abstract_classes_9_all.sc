/**
 * Abstract class with field and methods
 */
abstract class Date(day: Int, month: Int, year: Int) {
  def format: String
}

class DMY(day: Int, month: Int, year: Int) extends Date(day, month, year) {
  // override is optional when implementing abstract classes
  override def format: String = s"$day-$month-$year"
}

new DMY(1, 1, 1978).format


/**
 * Traits encapsulate fields and methods.
 *
 * Can be used to implement thin interfaces
 */
trait JsonAble {
  def toJson: String
}

/**
 * Trait mix-in can be done on class definition or object creation
 */
class JsonDate(day: Int, month: Int, year: Int) extends JsonAble {
  def toJson = s"""{"day":$day,"month":$month,"year":$year}"""
}

new JsonDate(1, 1, 2015).toJson

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

/**
 * Sealed traits can only be extended in the same file as its declaration.
 * The compiler knows every possible subtypes and can reason about it.
 */
sealed trait Answer

class Yes extends Answer

class No extends Answer

val x: Answer = new Yes
// this leads to a compiler warning
x match {
  case answer: No => "No"
}
