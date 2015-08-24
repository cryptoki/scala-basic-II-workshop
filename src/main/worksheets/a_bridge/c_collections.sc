val list1 = List()
val list2 = List()

// operator '::' defined in List
// use case case '::' which extends List
// add left operand as first element to the new list and return it
"a" :: "b" :: list1

// Operators ends with ':',
// expressions have to read from RIGHT to LEFT
// everything is a copy
"sdb" +: "c" +: list2

// => http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.immutable.List
