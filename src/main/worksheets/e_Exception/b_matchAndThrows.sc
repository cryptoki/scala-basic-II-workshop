import java.io.IOException

// let's go in detail
def exceptionGenerator(i: Int) = {
  i match {
    case 0 => throw new NumberFormatException("hello")
    case 1 => throw new NumberFormatException("abc")
    case _ => throw new IOException("bäh")
  }
}

0 to 5 foreach(x =>
  try {
    exceptionGenerator(x)
  }
  catch {
    case e: NumberFormatException if e.getMessage == "abc" => println("first")
    case e: NumberFormatException => println("second")
    case _ => println("buh")
  })

