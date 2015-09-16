val elvis = Seq("Patricia", "Rainer", "Heiner", "Jan", "Ingo", "Romain", "Steffen")

// TODO -1-  return Java like 'NULL' for non team member
def desk(name: String): Int = {
  // any idea?
  elvis.indexOf(name)
}

val a = desk("Patricia")
// what is the meaning of  -1
val b = desk("Björn")
