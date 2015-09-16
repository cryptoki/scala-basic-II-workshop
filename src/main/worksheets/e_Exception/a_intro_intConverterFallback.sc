// method to convert string into an Int
// ONLY values greater 0 are allowed
def convertToInt(input: String): Int = {
  val i:Int = input.toInt

  if (i < 0) {
    throw new IllegalArgumentException("only values greater 0 are allowed")
  }
  i
}

def convertFailsafeToInt(input: String): Int = {
  // TODO -1- use try and catch .. it's similar to Java, expect the catch
  // TODO -2- catch the IllegalArgumentException and return 0
  // TODO -3- all other exception, return -1
  convertToInt(input)
}


// call it :)
assert(convertFailsafeToInt("42") == 42)

assert(convertFailsafeToInt("42a") == 0)

assert(convertFailsafeToInt("-1234234") == -1)