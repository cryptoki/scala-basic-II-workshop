
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

