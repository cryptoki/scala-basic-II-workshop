// https://en.wikipedia.org/wiki/Date_format_by_country

abstract class Date(day: Int, month: Int, year: Int) {
  def format: String
}

// Does not work. Date is abstract
// new Date(1,2,3)

class DMY(day: Int, month: Int, year: Int) extends Date(day, month, year) {
  override def format: String = s"$day-$month-$year"
}

new DMY(1, 4, 1978).format

class YMD(day: Int, month: Int, year: Int) extends Date(day, month, year) {
  // override is optional when implementing abstract classes
  def format = s"$year-$month-$day"
}

new YMD(1, 2, 2015).format

class DMYExtended(day: Int, month: Int, year: Int, separator: String) extends DMY(day, month, year) {
  // override is mandatory when overriding concrete class
  // def format = ???
  override def format = List(day, month, year).mkString(separator)
}

new DMYExtended(1, 3, 2015, "/").format


final class TheEnd

// Does not work.
// class NotPossible() extends TheEnd