def sumEvenValuedTerms(maximum: Int) : Long = {
  val fibs: Stream[Long] = 0 #:: 1 #:: fibs.zip(fibs.tail).map(x => x._1 + x._2)
  fibs.takeWhile(x => x < maximum).filter( x => x%2 == 0).sum
}


assert(sumEvenValuedTerms(10) == 10)