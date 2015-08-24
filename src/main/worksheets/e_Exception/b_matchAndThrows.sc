import java.io.IOException

// let's go in detail

// write a execptionGenerator which produce different exceptions
// depends on i: Int
// explicit throws
@throws[NumberFormatException]
@throws[IOException]
def exceptionGenerator(i: Int) = {
  i match {
    case 0 => throw new NumberFormatException("hello")
    case 1 => throw new NumberFormatException("abc")
    case 2 => throw new IOException("abc")
    case 4 => throw new IOException("dsfxyzdsf")
    case _ => throw new IOException("bäh")
  }
}

// let's try pattern matching
0 until 5 foreach(x =>
  try {
    exceptionGenerator(x)
  }
  catch {
    case e: NumberFormatException if e.getMessage == "abc" => println("first")
    case e: NumberFormatException => println("second")
    case e: IOException if e.getMessage == "abc" || e.getMessage.contains("xyz") => println("third")
    case _: Throwable => println("buh")
  })

