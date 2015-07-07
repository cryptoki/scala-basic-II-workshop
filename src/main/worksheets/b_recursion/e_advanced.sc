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
lazy val stream: Stream[Int] = 1 #:: stream.map((x: Int) => x+1)
stream.take(10).foreach( x => print(x))
stream take 30 foreach print

// see whats happen in the next worksheet