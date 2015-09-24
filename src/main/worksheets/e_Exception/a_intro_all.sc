// ====================================
// intConverter
// ====================================

// there is a common way like in java

/**
 * method to convert string into an Int
 * ONLY values greater 0 are allowed
 */
def convertToInt(input: String): Int = {
  // TODO -1-  convert input: String  into  an Int
  val i:Int = input.toInt

  // TODO -2-  if converted int value < 0
  // -> throw IllegalArgumentException
  if (i < 0) {
    throw new IllegalArgumentException("only values greater 0 are allowed")
  }
  i
}

// call it :)
// TODO  -3-  call the method with different values



// ====================================
// intConverterFallback
// ====================================

/* => Anmerkung => convertToInt von oben wird hier genutzt */

def convertFailsafeToInt(input: String): Int = {
  try {
    // TODO -1-  use try and catch ..
    // it's similar to Java, expect the catch
    convertToInt(input)

  }
  // TODO -2-  catch NumberFormatException and return -1

  // TODO -3-  catch IllegalArgumentException and return 0
  catch {
    // NumberFormatException is a sub class of IllegalArgumentException
    case e: NumberFormatException => -1
    case e: IllegalArgumentException => 0
  }
}

// call it :)
// => 42
assert(convertFailsafeToInt("42") == 42)
// 0
assert(convertFailsafeToInt("42a") == -1)
// => -1
assert(convertFailsafeToInt("-1234234") == 0)