// simple case class to handle my own exception
case class MyException(val message: String) extends Exception(message)

val exceptionHandling: PartialFunction[Throwable, Int] = {
  case m: MyException => {
    println("I catch u")
    -4
  }
}

val globalExceptionHandling: PartialFunction[Throwable, Int] = {
  case e:Exception => {
    println(s"do not use message '${e.getMessage}'")
    -10
  }
}


exceptionHandling.isDefinedAt(new MyException("do not use!!!"))
exceptionHandling.isDefinedAt(new NumberFormatException)

val result1 = exceptionHandling.apply(new MyException("do not use!!!"))
val result2 = globalExceptionHandling(new MyException("do not use!!!"))
try {
  throw new MyException("cool stuff")
}
catch exceptionHandling

try {
  "abc".toInt
} catch exceptionHandling.orElse(globalExceptionHandling)


// macht es für Java eine Checked Exception
@throws[MyException]("bla bla bla")
def dangerousCall(test: Int): Int = {
  test match {
    case -1 => throw new Exception("do not use -1")
    case 0 => throw MyException("do not zero")
    case v => v
  }
}
dangerousCall(-1)

dangerousCall(2)
try {
  dangerousCall(-1)
}
catch {
  case m: MyException => {
    println("I catch u")
    -4
  }
  case e:Exception => {
    println(s"do not use message '$e'")
    -10
  }
}

try {
  dangerousCall(-1)
}
catch (exceptionHandling.orElse(globalExceptionHandling))




try {
  throw new MyException("blafoo")
}
catch globalExceptionHandling