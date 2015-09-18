import java.util

import scala.collection.immutable.{ListSet}

// ====================================
// Elvis Team
// ====================================
val elvis = Seq("Patricia", "Rainer", "Heiner",
  "Jan", "Ingo", "Romain", "Steffen")

// TODO -1- how can u return a Java like 'NULL'
// TODO     for non elvis team member
def deskNumber(name: String): Option[Int] = {
  // any idea?
  elvis.indexOf(name) match {
    case i: Int if i < 0 => None
    case i: Int => Some(i)
  }
}
// TODO -1 me-  implement explain the deskNumber method

val a = deskNumber("Patricia")
// what is the meaning of  -1
val b = deskNumber("Björn")


// ====================================
// Map
// ====================================
val notebookMapOfElvis = Map("Patricia" -> "Dell",
  "Rainer" -> "Dell",
  "Ingo" -> "Apple")

// TODO -1-  Print Ingo's notebook model
val ingo = notebookMapOfElvis.get("Ingo")
println(s"Ingo has a ${ingo.get}")
// TODO -2-  Print Björn's notebook model
val bjoern = notebookMapOfElvis.get("Björn")
// ups .. NoSuchElementException
// println(s"Björn has a ${bjoern.get}")
println(s"Björn has a ${bjoern.getOrElse("n/a")}")


// Java
// ====
val q: util.List[String] = new util.LinkedList[String]()
q.add("Patricia")
q.remove(0)
q
// Exception!
//val result = q.get(0)
//println(s"$result")

//// TODO -1-  convert the code into scala list
val l = ListSet("Patricia")
l.-("Patricia").-("jkdhsf")
l.find(x => x == "Patricia")
