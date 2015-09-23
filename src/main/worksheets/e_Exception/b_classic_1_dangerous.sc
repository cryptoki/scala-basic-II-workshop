import scala.util.Random

// classic format

// TODO -me-  explain very short the 3 parts
val result = try {
  // execution code
  doSomeDangerous()
}
catch {
  /* .. pattern matching stuff .. */
  // TODO -me-  generic catch
  // TODO       and explicit Typ declaration
  case _: Throwable => 42
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



// PUI => InvoiceDataExtractor