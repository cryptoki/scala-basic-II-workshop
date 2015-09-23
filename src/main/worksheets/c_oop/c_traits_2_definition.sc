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
class Date(day: Int, month: Int, year: Int) extends JsonAble {
  def toJson = s"""{"day":$day,"month":$month,"year":$year}"""
}

new Date(1, 1, 2015).toJson
