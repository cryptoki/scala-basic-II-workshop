import java.io.IOException

import scala.util.Random

// ====================================
// Dangerous
// ====================================

/* let's finish the intro with few more details */
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


// PUI => InvoiceDataExtractor

// ====================================
// Java
// ====================================

// TODO -1-  is it a checked or unchecked exception in scala?
// TODO -me-  write an explicit throws for Java
// TODO -me-  show the java <=> scala example
@throws[IOException]("oh. reading failed")
def doAnotherDangerous() = {
  throw new IOException
}

doAnotherDangerous()