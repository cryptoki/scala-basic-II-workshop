// get, getOrElse
val europeCapitals = Map(
  ("Germany" -> "Berlin"),
  ("Italy" -> "Rom"),
  ("Spain" -> "Madrid"),
  ("France" -> "Paris")
)

// TODO -1 a-  use get to get the capital of Poland
val get = ???
// TODO -1 b-  handle option with match / case


// TODO -2-  use getOrElse to get capital of Poland
val getOrElse = ???

// TODO -3-  chaining Options with orElse
//           -> use the capital map
//           -> use simple options
val orElseCapital = ???
val orElseExample = ???

// TODO -4-  what happend if u DONT check of Some/None?
val result: Option[String] = europeCapitals.get("Danemark")
// => call get


