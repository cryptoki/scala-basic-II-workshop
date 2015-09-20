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


// TODO -me-  List of Option with Some and None
val listOfOptions = List(Some(2), None, Some(4), Some(6), None)
// TODO -me-  concat Some and None of INT
val concatOptions = Some(2) ++ None ++ Some(4) ++ Some(6) ++ None

val option = Some(3)
// TODO -1-  how to evaluate if 3 is the result?
option.exists(x => x == 3)
option.exists(_ == 3)

// TODO -2-  use map functions for 'option'
//           multiple of 2
option.map(x => x*2)

// TODO -3-  convert 'listOfOptions' to a List[Int]
listOfOptions.filter(o => o.isDefined).map(o => o.get)
listOfOptions.flatMap(o => o.map(x => x))
listOfOptions.flatMap(o => o)
listOfOptions.flatten

// TODO -4-  accept only value '3' for option
option.filter(x => x==3)