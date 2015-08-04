// Option is a ..
// .. datatype to represent optional values

// Some
val some = Option.apply(2)
// None
val none = Option.empty

// two implementations of abstract class 'Option'

// 1  case class Some
// represents existing values of type
val some1 = Some(1234)

// 2  case object None
// represents non-existent values
val none1 = None
