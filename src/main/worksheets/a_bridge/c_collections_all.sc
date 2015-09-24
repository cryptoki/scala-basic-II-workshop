// +----------------------------------------------------+
// | Arrays       - mutable                             |
// | Lists        - immutable (normally)                |
// +----------------------------------------------------+

// ====================================
// Array
// ====================================
val array = Array(2,3,4,5)
array.update(2,400)
array


// ====================================
// List
// ====================================

// TODO -1-  define a list with values 1,2,3,4
val list1: List[Int] = List(1,2,3,4)

assert(list1.sum == 10)

// TODO -2-  define a list with value "b", "c"
val list2: List[String] = List("b", "c")

assert(list2(0) == "b")
assert(list2(1) == "c")


/* append
 * ------
 * the operator '::' is defined in List
 *   - Scala use internal case class '::' which extends List
 *   - add the left operand as first element to the new list and return it */
// TODO -me-  append value "a" to the head of list2
val list3:List[String] = "a" :: list2

assert(list3(0) == "a")

/* the same to :: */
list2.::("a")
/* => http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.immutable.List
 * => Scala Basic Part I */


// TODO -me- concat list2 and list3
val list4:List[String] = list2 ++ list3

assert(list4(2) == "a")


// TODO -me-  addon
// additional
val list5 = List(1,2)
// concat two lists
list5 ++ List(3,4)
// add right
list5 :+ 3
// add left
list5.+:(3)


// ====================================
// Methods
// ====================================
val seq1: Seq[Int] = Seq(1,2,3,4,5,6)

// TODO -1-  multiply each value by 2 and
//           sum up every value
val seq1Sum = seq1.map(x => x*2).sum
assert(seq1Sum == 42)

// TODO -me-  bring the synatic sugar
seq1.map((x: Int) => x*2).sum
seq1 map(_*2) sum

// TODO -me-  what is (x: Int) => x*2?
val f = (x: Int) => x*2
seq1.map(f).sum
seq1 map f sum


// +---------------------------------------------
// | TODO -me-  addon => only as reference
// | additional - reference
// +---------------------------------------------
// head / tail
seq1.head
seq1.tail
// some methods
seq1.filter(_ % 2 == 0)
seq1.groupBy(x => x%2)
seq1.reduce((x,y) => x+y)
seq1.partition(_ % 2 == 0)
// zip and map
val seq2: Seq[Int] = seq1.reverse
seq1.zip(seq2).map(x => x._1+x._2)
