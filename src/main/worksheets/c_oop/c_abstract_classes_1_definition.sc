
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
