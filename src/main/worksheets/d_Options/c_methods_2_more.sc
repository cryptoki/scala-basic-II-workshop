// GIVEN
val option: Option[Int] = Some(3)
//
// TODO -1-  how to evaluate if 3 is the result?
val existsOption: Boolean = ???
assert(existsOption == true)

// TODO -2-  use map functions for 'option' _and_
//           multiply with 2
val resultMultiply: Option[Int] = ???
assert(resultMultiply == Some(6))


// TODO -3-  convert 'listOfOptions' to a List[Int]
//           find 3 different ways
val listOfOptions = List(Some(2), None, Some(4), Some(5), None)

val result: List[Int] = ???
assert(result == List(2, 4, 6))

// TODO -4-  accept only value '3' for option
val resultModular2: List[Option[Int]] = ???
assert(resultModular2 == List(Some(2),Some(4)))

// TODO -me-  concat Some(3), None, Some(234)... with ++ operator
val concatOptions = ???

