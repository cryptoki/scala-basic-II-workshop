// +----------------------------------------------------+
// | Arrays       - mutable                             |
// | Lists        - immutable (normally)                |
// +----------------------------------------------------+

val array = Array(2,3,4,5)
array.update(2,400)
array


// define an empty list
val list1 = List()

// append
// ------
// the operator '::' is defined in List
//   - Scala use internal case class '::' which extends List
//   - add the left operand as first element to the new list and return it
"a" :: "b" :: list1

// the same to ::
list1.::("b").::("a")
// => http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.immutable.List
// => Scala Basic Part I


// ADD
val list2 = List(1,2)
list2 ++ List(3,4)
list2 :+ 3
list2.+:(3)
