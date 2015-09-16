
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
class Date(val day: Int, val month: Int, val year: Int) extends JsonAble {
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