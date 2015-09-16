// get, getOrElse
val europeCapitals = Map(
  ("Germany" -> "Berlin"),
  ("Italy" -> "Rom"),
  ("Spain" -> "Madrid"),
  ("France" -> "Paris")
)

// get
val poland = europeCapitals.get("Poland")
val result = poland match {
  case None => "oh no"
  case _ => "yeah found"
}

// getOrElse
val getOrElse = europeCapitals.getOrElse("Poland", "Warsaw")

// orElse
val orElse = europeCapitals.get("Danemark")
  .orElse(europeCapitals.get("Italy")).getOrElse("n/a")

// exception if not exists
val nseExc = europeCapitals.get("Danemark")
nseExc.get

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