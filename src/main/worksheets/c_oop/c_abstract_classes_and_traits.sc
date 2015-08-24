
/**
 * Abstract class with field and methods
 *
 * [[https://en.wikipedia.org/wiki/Date_format_by_country]]
 */
abstract class Date(val day: Int, val month: Int, val year: Int) {
  def format: String
}

class DMY(day: Int, month: Int, year: Int) extends Date(day, month, year) {
  // override is optional when implementing abstract classes
  override def format: String = s"$day-$month-$year"
}

val dmy = new DMY(1, 1, 1978).format

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
new DMY(1, 1, 1978) with JsonAble {
  // @formatter:off
  def toJson =
    s"""
       |{
       |"year": "$year",
       |"month": "$month",
       |"day": "$day"
       |}
     """.stripMargin
  // @formatter:on
}


/**
 * How to handle multiple traits defining methods with same signature?
 */
trait A {
  def foo = "A"
}

trait B {
  def foo = "B"
}

class C extends A with B {
  override def foo = super[A].foo
}

val c = new C().foo