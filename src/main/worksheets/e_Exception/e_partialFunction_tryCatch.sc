val handler: PartialFunction[Throwable, Int] = {
  case m: NumberFormatException => {
    println("I catch u")
    -1
  }
}
val globalHandler: PartialFunction[Throwable, Int] = {
  case e:Throwable => {
    println(s"danger! '${e.getMessage}'")
    Int.MinValue
  }
}


// TODO -1- use try and catch and both handler to
//          a ) convert "abc".toInt
//          b ) throw new NoSuchElementException("do not use! :)")

