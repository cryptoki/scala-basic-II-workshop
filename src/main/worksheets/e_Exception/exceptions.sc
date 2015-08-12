case class MyException(message: String) extends Exception(message)

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

val exceptionHandling: PartialFunction[Throwable, Int] = {
  case m: MyException => {
    println("I catch u")
    -4
  }
}

val globalExceptionHandling: PartialFunction[Throwable, Int] = {
  case e:Exception => {
    println(s"do not use message '$e'")
    -10
  }
}

exceptionHandling.isDefinedAt(new MyException("do not use!!!"))
// ruft die partial function auf
exceptionHandling.apply(new MyException("do not use!!!"))
exceptionHandling(new MyException("do not use!!!"))

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
