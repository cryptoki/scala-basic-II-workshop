// TODO -1-  write a stream for the factorial problem
val streamFactorial: Stream[(Long, Long)] = ???

//streamFactorial take 4 print
assert(streamFactorial.drop(3).head._2 == 24)

// we have t