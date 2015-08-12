// there is a common way like in java

// okay, lets write a method to convert a string into an int
// value, if it's not possible it should deliver 0 als default
def intConverter(input: String): Int = {
  try {
    val i: Int = input.toInt
    if (i == -1)
      throw new RuntimeException

    i
  }
  catch {
    case e: NumberFormatException => -1
    case _ => 0
  }
}

// modify converter to
// => -1
intConverter("34a")
// => 3
intConverter("3")
// => 0 - throw another exception if it's 0 and catch it
intConverter("-1")
