// ====================================
// Intro
// ====================================
val notebookMapOfElvis = Map(
  "Patricia" -> "Dell", "Rainer" -> "Dell",
  "Ingo" -> "Apple", "Rainer" -> "Dell")

// TODO -1-  whats happend if the name not exists?
def getNotebook(teamMember: String): String = {
  // TODO -2-  can you return a null like in Java?
  notebookMapOfElvis.get(teamMember).getOrElse("n/a")
}

// TODO -1-  Implement the getNotebook method
val ingosNotebook = getNotebook("Ingo")
println(s"Ingo has a ${ingosNotebook}")
assert(ingosNotebook == "Apple")

// TODO -2-  Does the getNotebook method work for 'steffensNotebook'?
val steffensNotebook = getNotebook("Steffen")
println(s"Steffen has a ${steffensNotebook}")


// Option is a ..
// .. datatype to represent optional values
// .. value that could be exists or not.
// solve the NULL check hell in Java

// two implementations of abstract class 'Option'

// ====================================
// Some
// ====================================
// 1  case class Some
// represents existing values of type
val some1 = Some(1234)

val some2 = Option.apply(2)


// ====================================
// None
// ====================================

// 2  case object None
// represents non-existent values
val none1 = Option.empty

val none2 = None
