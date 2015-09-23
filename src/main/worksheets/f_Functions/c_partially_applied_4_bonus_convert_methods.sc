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
// TODO: val squareRef = Math.square
