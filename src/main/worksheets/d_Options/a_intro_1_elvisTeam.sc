val elvis = Seq("Patricia", "Rainer", "Heiner",
  "Jan", "Ingo", "Romain", "Steffen")

// TODO -1-  how can u return a Java like 'NULL'
// TODO      for non elvis team member
def deskNumber(name: String): Int = {
  // any idea?
  elvis.indexOf(name)
}

// TODO -1 me-  implement explain the deskNumber method

val a = deskNumber("Patricia")
// what is the meaning of  -1
val b = deskNumber("Björn")
