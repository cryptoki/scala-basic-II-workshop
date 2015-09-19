var x = 3
def example() = {
  val a = x*x
  lazy val b = x*x

  x=25
  // TODO -1-  which value has a and b?
  println(s"a=___ - b=___")
}
example()
