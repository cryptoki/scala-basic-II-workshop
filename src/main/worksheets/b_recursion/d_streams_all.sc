/* Die letzte Kategorie der `lazy collections` bildet der Stream.
   Er erzeugt seine Elemente ebenfalls erst auf Anfrage speichert bereits
   berechnete Elemente aber ab um im Bedarfsfall schnell wieder darauf zugreifen
   zu können. Der größte Vorteil von Streams ist unendlich lange Collections zu
   erzeugen, gegebenfalls auch rekursiv. */

// ====================================
// Beyond
// ====================================

// more ways to implement a recursion
// you can define a building description for streams.

// use a simple List of odd Int from 1 to 20
val simpleListOfOddNumber: List[Int] = 1 to 20 by 2 toList
val streamOfLimitedOddNumber: Stream[Int] = simpleListOfOddNumber.toStream


// TODO -1-  take first 10 from the stream and print it
streamOfLimitedOddNumber take 10 foreach(x => print(s"$x, "))


// TODO -2-  implement a stream definition for odd numbers
//           we want to implement the same of odd numbers
val streamOfOddNumbers: Stream[Int] =
      1 #:: streamOfOddNumbers.map((x: Int) => x+2)

// TODO -me-  take a look into the scala documentation #:: / cons
val streamOfOddNumbersCons: Stream[Int] =
      Stream.cons(1, streamOfOddNumbersCons map (_+2))

// ==> Test cases
val resultStreamOffOddNumbers: List[Int] =
      streamOfOddNumbers.take(10).toList
val resultStreamOffOddNumbersCons: List[Int] =
      streamOfOddNumbersCons.take(10).toList
assert(simpleListOfOddNumber == resultStreamOffOddNumbers)
assert(simpleListOfOddNumber == resultStreamOffOddNumbersCons)

// TODO -1-  go to Scala API Stream.from
Stream from (1, 2) take 10 print



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


// ====================================
// Factorial
// ====================================

// TODO -1-  write a stream for the factorial problem
lazy val streamFactorial: Stream[(Long, Long)] =
  (1,1) #:: streamFactorial.map(x => (x._1+1l, x._2*(x._1+1l)))
streamFactorial take 4 print

assert(streamFactorial.drop(3).head._2 == 24)



// ====================================
// Exercise
// ====================================

/**
 * Infinity stream definition
 *
 * every definition means the same. the values will be evaluate if it's needed
 * 1. - take the first = 1
 * 2. - #:: = cons => def apply[A](hd: A, tl: => Stream[A]) = new Cons(hd, tl)
 *      You can see :=> is mean as call by name. Only if it's needed it is evaluated
 *      1 = hd, Stream(1) => the stream is mapped 1+1 => 1, 2 = the new stream
 *      calculated values does NOT need to reevaluate => only one step is necessary 1+1=2
 * 3. - #:: the same .. 1 = hd (head) and Stream(1,2) = tl (stream)
 *      It's evaluated at the point when the THIRD element is requested an now the stream
 *      1, 2 is mapped to 2, 3 and the head is append as first element = 1, 2, 3
 *      same here, only the 3. value is evaluated 2+1 = 3
 * 4. - same step 3
 *
 * The important distinction which allows infinite list to be infinite is the fact that
 * this tail is lazily evaluated only if it's needed and everytime again i
 *   Call by NAME -> you can see it in the method definition "tl: => Stream[A]"
 *
 *
 * The critical distinction which allows infinite lists to be infinite is the fact
 * that this tail is lazily evaluated.  That means that the tail as a value is not
 * available until you ask for it.
 *
 * One very important property of from which should immediately jump out at you is
 * the fact that it is infinitely recursive.  It takes a number, invokes this
 * mysterious #:: operator on that value and then recursively calls back to itself.
 * There is no conditional guard, no base case, just an endless series of calls.
 * Intuitively, this should lead to non-termination at runtime... except that it doesn’t.
 * Remember what I said about the lazily-evaluated tail? This is where that idea really
 * begins to take effect. The from function is not infinitely recursive; at least, not right away.
 */

// TODO -me-  use the stream example and print it out
lazy val stream: Stream[Int] = 1 #:: stream.map((x: Int) => {
  println(s" map $x + 1 = " + (x+2l))
  x+2
})
stream take 4 foreach(x => println(s"found next: $x"))


// TODO -1-  Is it the same?
val firstValue: Int = 1
lazy val streamLeftAssociative: Stream[Int] =
  streamLeftAssociative.map(x => {
    //  println(s" map $x + 1 = " + (x+1l))
    x+1
  }).#::(firstValue)
streamLeftAssociative take 4 // foreach(x => println(s"found next: $x"))

// TODO -2-  Is it the same?
def streamAsFunction: Stream[Int] = 1 #:: streamAsFunction.map((x: Int) => {
  //  println(s" map $x + 1 = " + (x+1l))
  x+1
})
streamAsFunction take 4 // foreach(x => println(s"found next: $x"))




/* val test: Stream[Int] = 1 #:: 2 => Compiler Error => #:: is an operator from Stream
 * #:: ConsWrapper => Cons.apply => fügt dem Stream ein Head Element hinzu
 * => Initial Stream ist empty => 2+Empty Stream => 1 + Stream(2) => danach zuweisen des Ergebnis
 *    an test
 * => Stream ist gefüllt mit 1, 2 Elemente
 * => Bauvorschrift führt jetzt den vorhergehenden Schritt wieder aus
 * => 1 + 2 + Stream(1,2)
 *
 * Definition eines Streams welcher sich selbst rekursiv erstellt
 * => Bauvorschrift
 * #:: rechts assoziativer Operator cons
 * 0 + 1 + stream
 * tupel und hinzufügen durch tupel Addition */
