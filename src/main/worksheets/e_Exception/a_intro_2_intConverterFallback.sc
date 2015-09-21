/** reuse convert method from worksheet before */
def convertToInt(input: String): Int = {
  val i:Int = input.toInt

  if (i < 0) {
    throw new IllegalArgumentException("only values greater 0 are allowed")
  }
  i
}

/**
 * a fallback method which use the convertToInt
 */
def convertFailsafeToInt(input: String): Int = {
  // TODO -1-  use try and catch ..
  // it's similar to Java, expect the catch

  convertToInt(input)

  // TODO -2-  catch NumberFormatException and return -1

  // TODO -3-  catch IllegalArgumentException and return 0
}


// call it :)
assert(convertFailsafeToInt("42") == 42)

assert(convertFailsafeToInt("42a") == 0)

assert(convertFailsafeToInt("-1234234") == -1)