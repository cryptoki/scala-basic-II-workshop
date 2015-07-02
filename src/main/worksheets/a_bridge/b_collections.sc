/**
 * Operatoren welche mit einem ':' Enden, sind die Ausdrücke von recht nach links zu lesen!
 */
val list1 = List()
val list2 = List()
"a" :: "b" :: list1 // => :: case class extends List, fügt ein Element zur Liste hinzu
"sdb" +: "c" +: list2 // => copy der Liste mit angefügten Element

// => http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.immutable.List

val bla = "a" :+ "b"
