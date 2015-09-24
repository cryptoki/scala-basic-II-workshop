// ====================================
// Into
// ====================================

// get, getOrElse
val europeCapitals = Map(
  ("Germany" -> "Berlin"),
  ("Italy" -> "Rom"),
  ("Spain" -> "Madrid"),
  ("France" -> "Paris")
)

// get
// TODO -1 a-  use get to get the capital of Poland
val maybePolandCapital: Option[String] = europeCapitals.get("Poland")

//
// TODO -1 b-  handle option with match / case
//             Some -> return capital
//             Nome -> return "not available"
val capitalOfPolandByPm = maybePolandCapital match {
  case None => "not available"
  case Some(x) => x
}

// getOrElse
// TODO -2-  use getOrElse to get capital of Poland
val capitalOfPolandByGetOrElse: String = maybePolandCapital.getOrElse("Warsaw")
// usage with map
europeCapitals.getOrElse("Poland", "Warsaw")

// orElse
// TODO -3-  chaining Options with orElse
//           -> maybeCapital maybe capital of Poland orElse Italy
val maybeItalyCapital: Option[String] = europeCapitals.get("Italy")
val maybeCapital: Option[String] = maybePolandCapital.orElse(maybeItalyCapital)


// exception if not exists
// TODO -4-  what happend if u DONT check of Some/None?
val nseExc = maybePolandCapital


// ====================================
// More
// ====================================

/* explicit documentation of Option[xyz] as return value
 * point that something can missed. */

/* you can not call a method on a value which is null
 * NO null check java hell */


// GIVEN
val option = Some(3)
// TODO -1-  how to evaluate if 3 is the result?
val existsOption: Boolean = option.exists(x => x == 3)
option.exists(_ == 3)
assert(existsOption == true)
// TODO -2-  use map functions for 'option' _and_
//           multiply with 2
val resultMultiply: Option[Int] = option.map(x => x*2)
assert(resultMultiply == Some(6))


// TODO -3-  convert 'listOfOptions' to a List[Int]
//           find 3 different ways
val listOfOptions = List(Some(2), None, Some(4), Some(5), None)
val result: List[Int] = listOfOptions.filter(o => o.isDefined).map(o => o.get)
listOfOptions.flatMap(o => o.map(x => x))
listOfOptions.flatMap(o => o)
listOfOptions.flatten
assert(result == List(2, 4, 5))


// TODO -4-  accept only value '3' for option
val resultModular2: List[Option[Int]] =
  listOfOptions.filter(o => o.exists(y => y%2==0))
assert(resultModular2 == List(Some(2),Some(4)))

// TODO -me-  concat Some and None of INT
val concatOptions = Some(2) ++ None ++ Some(4) ++ Some(6) ++ None
