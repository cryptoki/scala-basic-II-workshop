case class MyException(message: String) extends Exception(message)

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
