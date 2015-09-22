// get, getOrElse
val europeCapitals = Map(
  ("Germany" -> "Berlin"),
  ("Italy" -> "Rom"),
  ("Spain" -> "Madrid"),
  ("France" -> "Paris")
)

// TODO -1 a-  use get method to get the capital of Poland
val maybePolandCapital = ???

//
// TODO -1 b-  handle option with match / case
//             Some -> return capital
//             Nome -> return "not available"
val capitalOfPolandByPm: String = ???

// getOrElse
// TODO -2-  use getOrElse to get capital of Poland
val capitalOfPolandByGetOrElse: String = ??? // maybePolandCapital.
// usage with map
europeCapitals.getOrElse("Poland", "Warsaw")

// orElse
// TODO -3-  chaining Options with orElse
val maybeItalyCapital: Option[String] = europeCapitals.get("Italy")
// -> maybeCapital maybe capital of Poland orElse Italy
val maybeCapital: Option[String] = ???


// exception if not exists
// TODO -4-  what happend if u DONT check of Some/None?
// => call get
val nseExc = maybePolandCapital


