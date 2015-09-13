
try {
  // execution code
}
catch {
  case e: IllegalArgumentException => // everything has a value
  case e: IllegalStateException    =>
  /* ... */
  case _: Throwable =>
}
finally {
  // execution every time
}


val a = try {
  throw new Exception()
  "cvb".toInt
}
catch {
  case e: NumberFormatException => 3
  case _:Throwable => 4
}
finally {
  println("Blafoo")
}