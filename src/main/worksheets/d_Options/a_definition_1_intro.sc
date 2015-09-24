val notebookMapOfElvis = Map("Patricia" -> "Dell",
  "Rainer" -> "Dell",
  "Ingo" -> "Apple",
  "Rainer" -> "Dell")

// TODO -1-  whats happend if the name not exists?
def getNotebook(teamMember: String): String = {
  // TODO -2-  can you return a null like in Java?
  ???
}

// TODO -3-  Implement the getNotebook method
val ingosNotebook = getNotebook("Ingo")
println(s"Ingo has a ${ingosNotebook}")
assert(ingosNotebook == "Apple")

// TODO -4-  Does the getNotebook method work for 'steffens Notebook'?
val steffensNotebook = ???
println(s"Steffen has a ${steffensNotebook}")
