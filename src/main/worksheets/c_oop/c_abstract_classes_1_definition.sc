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
