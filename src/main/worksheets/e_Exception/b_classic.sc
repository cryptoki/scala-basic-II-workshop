import scala.util.Random

// ====================================
// Dangerous
// ====================================

// let's finish the intro with few more details
@throws[NumberFormatException]("oh. converting failed")
@throws[NullPointerException]("welcome to the null hell")
def doSomethingDangerous(): Int = {
  Random.nextInt(3) match {
    case 0 => throw new NumberFormatException
    case 1 => throw new NullPointerException
    case _ => throw new RuntimeException
  }
}


// everything has a value
val result = try {
  // execution code
  doSomethingDangerous()
  42
}
catch {
  case e: NumberFormatException =>
    // everything has a value
    1
  case e: NullPointerException => 2
  /* .. more pattern matching stuff .. */
  case _: Throwable => 3
}
finally {
  // execution every time
  println("hello :)")
}

