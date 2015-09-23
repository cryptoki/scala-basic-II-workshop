import scala.collection.mutable.ListBuffer

// mutable
val l = new ListBuffer[String]()
l+="a"
l+="b"


// immutable
val str = "Hello"
val str2 = str + " world!"
str2.eq(str)


l.toList
var oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ++ threeFour
oneTwo

val l1 = List(1,2)
val l2 = 3 +: l1
val l2b = 5 :: l2
val l3 = l1 :+ 2
val l4 = l1 ++ l2


val oneTwoThree1 = 1 :: 2 :: 3 :: Nil
val oneTwoThree2 = Nil.::(3).::(2).::(1)


val myList = List(1,2,3,4,5,6)
myList
  .map(i=> i+1)
  .filter(i => i%2 == 0)
  .map(i => s"-$i-\n")
  .foreach(s => print(s))

myList
  .map(_+1)
  .filter(_%2==0)
  .map("-"+_+"-\n")
  .foreach(print)

"hello".map(_.toUpper)

for (ele <- myList) yield ele + 1


val lb1 = List(2,3,4,5)
lb1 match {
  case head +:Nil => println(s"found head ${head}")
  case bla1 +: bla2 +: bla3 +: bla4 +: bla5=> println(s"blubber")
  case head +: head2 +: tail => println(s"found head=$head head2=$head2 with ${tail.length}")
  case head +:tail => println(s"found tail with length ${tail.length}")
  case Nil => println("Empty")
  case _ => println("bla")
}