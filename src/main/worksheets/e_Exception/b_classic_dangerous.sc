import scala.util.Random

// classic format

val result = try {
  // execution code
  doSomeDangerous()
}
catch {
  /* .. pattern matching stuff .. */
  case _: Throwable => 42
  // TODO -1- implement the case pattern matching for all 3 Exceptions
  // TODO     return 1, 2 and 3
}
finally {
  // execution every time
}

assert(result >= 0 && result <= 100)




def doSomeDangerous(): Int = {
  Random.nextInt(3) match {
    case 0 => throw new NumberFormatException
    case 1 => throw new NullPointerException
    case _ => throw new RuntimeException
  }
}
