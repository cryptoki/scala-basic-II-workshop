//

def failing(i: Int): Int = {
  val y: Int = throw new Exception("fail")
  try {
    val x = 42 + y
    x + y
  }
  catch {
    case e: Exception => 42
  }
}
// failing(3)

// exceptions are not type safe
val x: String = throw new Exception("I'm a string")
// compiler will not force callers to make a decision about
// how to handle those exceptions
// if we forget to check for an exception this won't be
// detected until runtime


// idea - instead of throwing an exception, we return a value
// indicating that an exceptional condition has occurred
// -> familiar used return code in C to handle exceptions
// -> introduce a new generic type for these  possibly defined values

def mean(xs: Seq[Double]): Double = {
  if (xs.isEmpty)
    throw new ArithmeticException("mean of empty list!")
  else
    xs.sum / xs.length
}
// -> without exception => return some Double.NaN or other
// value for not defined

