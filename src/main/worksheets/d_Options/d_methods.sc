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
val poland = europeCapitals.get("Poland")
// TODO -1 b-  handle option with match / case
val result = poland match {
  case None => "oh no"
  case _ => "yeah found"
}

// getOrElse
// TODO -2-  use getOrElse to get capital of Poland
val getOrElse = europeCapitals.getOrElse("Poland", "Warsaw")

// orElse
// TODO -3-  chaining Options with orElse
//           -> use the capital map
//           -> use simple options
val orElseCapital = europeCapitals.get("Danemark")
  .orElse(europeCapitals.get("Italy")).getOrElse("n/a")
val orElseExample = None.orElse(Some(3).orElse(Some(4)))


// exception if not exists
// TODO -4-  what happend if u DONT check of Some/None?
val nseExc = europeCapitals.get("Danemark")
// nseExc.get

// ====================================
// More
// ====================================

// explicit documentation of Option[xyz] as return value
// point that something can missed.

// you can not call a method on a value which is null
// NO null check java hell


val listOfOptions = List(Some(2), None, Some(4), Some(6), None)
val concatOptions = Some(2) ++ None ++ Some(4) ++ Some(6) ++ None

val option = Some(3)
option.exists(_ == 3)
option.exists _ == 3

option.map(x => x*2)
listOfOptions.filter(x => x.isDefined).map(x => x.get)
listOfOptions.flatten

option.filter(x => x==3)