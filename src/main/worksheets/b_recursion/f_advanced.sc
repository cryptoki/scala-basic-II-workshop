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

/**
 * Infinity stream definition
 */
lazy val stream: Stream[Int] = 1 #:: stream.map((x: Int) => x+1)
// it's the same
val firstValue: Int = 1
lazy val streamWithOutSugar: Stream[Int] = streamWithOutSugar.map(x => x+1).#::(firstValue)
streamWithOutSugar take 4 foreach print
// it's the same
def streamAsFunction: Stream[Int] = 1 #:: streamAsFunction.map((x: Int) => x+1)
streamAsFunction take 4 foreach print

/**
 * every definition means the same. the values will be evaluate if it's needed
 * 1. - take the first = 1
 * 2. - #:: = cons => def apply[A](hd: A, tl: => Stream[A]) = new Cons(hd, tl)
 *      the tail will be evaluate if it's needed, so make recursive call and add one
 * 3. - same step 2, existing evaluated values will not reevaluate - add one = 3
 * 4. - same step 3
 */

/**
 * The critical distinction which allows infinite lists to be infinite is the fact
 * that this tail is lazily evaluated.  That means that the tail as a value is not
 * available until you ask for it.
 *
 * One very important property of from which should immediately jump out at you is
 * the fact that it is infinitely recursive.  It takes a number, invokes this
 * mysterious :: operator on that value and then recursively calls back to itself.
 * There is no conditional guard, no base case, just an endless series of calls.
 * Intuitively, this should lead to non-termination at runtime…except that it doesn’t.
 * Remember what I said about the lazily-evaluated tail? This is where that idea really
 * begins to take effect. The from function is not infinitely recursive; at least, not right away.
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