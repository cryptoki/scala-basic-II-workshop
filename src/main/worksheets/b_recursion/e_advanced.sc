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
val stream: Stream[Int] = 1 #:: stream.map(_+1)
stream take 10 foreach print
stream take 30 foreach print

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
