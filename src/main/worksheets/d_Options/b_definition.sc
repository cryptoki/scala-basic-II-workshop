// Option is a ..
// .. datatype to represent optional values
// .. value that could be exists or not.
// solve the NULL check hell in Java

// two implementations of abstract class 'Option'

// ====================================
// Some
// ====================================
// 1  case class Some
// represents existing values of type
val some1 = Some(1234)

val some2 = Option.apply(2)


// ====================================
// None
// ====================================

// 2  case object None
// represents non-existent values
val none1 = Option.empty

val none2 = None
