import scala.collection.immutable.Stream
import scala.collection.immutable.Stream.Cons

/**
 * operators ending by : are right associative
 * you have to read from RIGHT _to_ LEFT
 *
 * Scala Spec
 * ----------
 * A left-associative binary operation e1 op e2 is interpreted as e1.op(e2).
 * If op is right-associative, the same operation is interpreted as { val x =e1; e2.op(x) },
 * where x is a fresh name.
 * -> only one parameter for right-associative
 * -> val x = List(5,6,7)
 *    1 #:: x => val y = 1
 *               x.#::(y)
 */
val x = List(5,6,7)
val conX = 1 +: x
val y = 1
val conY = x.+:(1)


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