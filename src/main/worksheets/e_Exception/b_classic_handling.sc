import scala.util.Random

// TODO -1- implement a doSomeDangerous method which throws exception
// TODO     depend on a random value
def doSomeDangerous(): Int = {
  Random.nextInt(3) match {
    case _ => 1
  }
}


// classic format

val result = try {
  // execution code
  doSomeDangerous()
}
catch {
  /* .. pattern matching stuff .. */
  // TODO -2- implement the case pattern matching for all 3 Exceptions
  // TODO     return 1, 2 and 3
  case _: Throwable => 2
}
finally {
  // execution every time
}




assert(result >= 0 && result <= 100)