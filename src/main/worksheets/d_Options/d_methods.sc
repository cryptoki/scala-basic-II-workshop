import scala.runtime.RichInt

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

val nseExc = europeCapitals.get("Danemark")
nseExc.get

// explicit documentation of Option[xyz] as return value
// point that something can missed.

// you can not call a method on a value which is null
// NO null check java hell

