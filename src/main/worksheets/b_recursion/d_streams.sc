// ====================================
// Intro
// ====================================

/**
 * more ways to implement a recursion
 *
 * you can define a building description for streams.
 */

// simple Seq of Int from 1 to 20
val simpleList: List[Int] = 1 to 20 by 2 toList


// take first 10 from the stream and print it
simpleList.toStream take 10 foreach print


// you can also define a stream definition
lazy val streamStep2: Stream[Int] = 1 #:: streamStep2.map((x: Int) => x+2)
val resultStep2: List[Int] = streamStep2.take(10).toList
assert(simpleList == resultStep2)


// see whats happen in the next worksheet

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
