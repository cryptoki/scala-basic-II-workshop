// there is a common way like in java

// okay, lets write a method to convert a string into an int value
// ONLY values greater 0 are allowed
def convertToInt(input: String): Int = {
  val i:Int = input.toInt

  if (i < 0) {
    throw new IllegalArgumentException("only values greater 0 are allowed")
  }
  i
}

def convertFailsafeToInt(input: String): Int = {
  try {
    convertToInt(input)
  }
  catch {
    // NumberFormatException is a sub class of IllegalArgumentException
    case e: NumberFormatException => -1
    case e: IllegalArgumentException => 0
  }
}


// modify converter to
// => -1
convertFailsafeToInt("dsf")
// => 3
convertFailsafeToInt("3")
// => 0
convertFailsafeToInt("-1")
