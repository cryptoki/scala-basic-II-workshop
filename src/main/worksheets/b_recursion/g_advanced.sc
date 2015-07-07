import scala.collection.immutable.Stream
import scala.collection.immutable.Stream.Cons

/**

  */

def blafooBlub: Stream[Int] = 8 #:: blafooBlub.map(x => 1)
blafooBlub take 4 foreach(print)

def numsFrom (n :Int): Stream[Int] = Stream.cons(n,numsFrom(n+1))
//lazy val N = numsFrom(0)

//lazy val N: Stream[Int] = Stream.cons(0, N.map(x => x+1))
//def bla: () = N.map(x => x+1)

val bla = List(1,2,3,4).toStream

val blub= () => bla.map(x => x+1)
val blubber: Stream[Int] = blafoo(0, bla)

/** A stream consisting of a given first element and remaining elements
  *  @param hd   The first element of the result stream
  *  @param tl   The remaining elements of the result stream
  */
// call by value, call by name
def blafoo[A](hd: A, tl: => Stream[A]) = {
  new Cons(hd, tl)
}


val tl: Stream[Int] = {
  bla
}


// val test: Stream[Int] = 1 #:: 2 => Compiler Error => #:: is an operator from Stream
// #:: ConsWrapper => Cons.apply => fügt dem Stream ein Head Element hinzu
// => Initial Stream ist empty => 2+Empty Stream => 1 + Stream(2) => danach zuweisen des Ergebnis
//    an test
// => Stream ist gefüllt mit 1, 2 Elemente
// => Bauvorschrift führt jetzt den vorhergehenden Schritt wieder aus
// => 1 + 2 + Stream(1,2)
val test: Stream[Int] = 1 #:: 2 #:: test
test take 3 foreach print

val a1 = 1
val b1 = 2
lazy val blafoo: Stream[Int] = (blafoo.map(_*2).#::(b1)).#::(a1)
blafoo take 10 foreach print



// you created a stream definition for an infinite 121212....1212 stream
val anotherTest: Stream[Int] = 1 #:: 5 #:: anotherTest.map( x => {
  println(" ->x: " + x)
  x*2
})
anotherTest take 10 foreach print
// 1, Empty Stream
// 1, 1*2
// 1, 2, 2*2
// 1, 2, 4, 4*2

// 1, 2, Empty Stream
// 1, 2, 1*2, 2*2
// 1, 2, 2, 4, 2*2, 4*2
//val fibs: Stream[BigInt] =
//  BigInt(0) #:: BigInt(1) #:: BigInt(2) #:: fibs


val hallo : BigInt = 1

Range.apply(0,10)

// Definition eines Streams welcher sich selbst rekursiv erstellt
// => Bauvorschrift
// #:: rechts assoziativer Operator cons
// 0 + 1 + stream
// tupel und hinzufügen durch tupel Addition
val bla : Stream[Int]=
  0 #:: 1 #:: bla.zip(bla.tail).map(x => {
    println(x)
    x._1 + x._2
  })
bla take 10 foreach println

bla take 100 foreach println
val fibs: Stream[Long] = 1 #:: 2 #:: fibs.zip(fibs.tail).map(x => x._1 + x._2)
// val count = fibs.count(x => x < 10)
fibs.takeWhile(x => x < 10) foreach println
fibs.takeWhile(x => x < 10).size


// Faktorzerlegung
def factors(n: Long): List[Long] =
  (2 to math.sqrt(n).toInt).find(n % _ == 0)
    .map(i => i.toLong :: factors(n / i)).getOrElse(List(n))

factors(1111111111111111l)


def listOfPrims(maximum: Int) : Stream[Int] = {
  Range(1, maximum).filter( x => {
    Range(2, Math.sqrt(maximum).toInt).filter( y => x%y == 0).size == 0
  }).toStream
}

listOfPrims(100000) foreach(println)

