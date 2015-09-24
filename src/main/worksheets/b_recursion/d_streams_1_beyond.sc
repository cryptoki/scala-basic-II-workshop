// more ways to implement a recursion
// you can define a building description for streams.


// use a simple List of odd Int from 1 to 20
val simpleListOfOddNumber: List[Int] = 1 to 20 by 2 toList
val streamOfOddNumber: Stream[Int] = simpleListOfOddNumber.toStream


// TODO -1-  take first 10 from the stream and print it
streamOfOddNumber take 10 foreach(x => print(s"$x, "))


// TODO -2-  implement a stream definition for odd numbers
//           we want to implement the same of odd numbers
val streamOfOddNumbers: Stream[Int] = ???

// TODO -me-  take a look into the scala documentation #:: / cons
val streamOfOddNumbersCons: Stream[Int] = ???

// ==> Test cases
val resultStreamOffOddNumbers: List[Int] =
  streamOfOddNumbers.take(10).toList
val resultStreamOffOddNumbersCons: List[Int] =
  streamOfOddNumbersCons.take(10).toList
assert(simpleListOfOddNumber == resultStreamOffOddNumbers)
assert(simpleListOfOddNumber == resultStreamOffOddNumbersCons)

