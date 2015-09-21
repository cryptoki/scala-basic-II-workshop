/**
 * Named functions, methods and local functions can't be used as arguments
 * or assigned to a val (in all cases).
 */
object Math {
  def square(x: Int) = x * x

  val sum = (x: Int, y: Int) => x + y
}

val sumRef = Math.sum


// Audience: This does not work. How to fix?
//val squareRef = Math.square

/**
 * When the compiler knows that a function is expected the underscore can be omitted
 */
val fRef: Int => Int = Math.square

1 to 100 map (x => Math.square(x))
1 to 100 map (Math.square(_))
1 to 100 map (Math.square)
1 to 100 map Math.square
