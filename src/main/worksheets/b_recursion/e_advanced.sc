/**
 * more ways to implement a recursion
 *
 * you can define a building description for streams.
 */

// okay, simple List of Integer from 1 to 20, remember to = inclusive, until is exclusive
val simpleList = 1 to 20
// simple way to sum up
simpleList.toStream.sum
// take first 10 from the stream and print it
simpleList.toStream take 10 foreach print _
// take first 30 from the stream and print it, ups only 20 are in the stream.
simpleList.toStream take 30 foreach print


// you can also define a stream definition
val stream: Stream[Int] = 1 #:: stream.map((x: Int) => x+1)
stream.take(10).foreach( x => print(x))
stream take 30 foreach print

/**
 * operators ending by : are right associative
 * you have to read from RIGHT _to_ LEFT
 */
// val test: Stream[Int] = 1 #:: 2 => Compiler Error => #:: is an operator from Stream
// #:: ConsWrapper => Cons.apply => fügt dem Stream ein Head Element hinzu
// => Initial Stream ist empty => 2+Empty Stream => 1 + Stream(2) => danach zuweisen des Ergebnis
//    an test
// => Stream ist gefüllt mit 1, 2 Elemente
// => Bauvorschrift führt jetzt den vorhergehenden Schritt wieder aus
// => 1 + 2 + Stream(1,2)
val test: Stream[Int] = 1 #:: 2 #:: test
test take 3 foreach print

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