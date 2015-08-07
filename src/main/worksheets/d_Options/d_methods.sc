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