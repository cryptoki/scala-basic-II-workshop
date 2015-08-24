// let's repeat some basics

// var/val
val a = 1
var b : Int = 2
b = 3

def quadrat(x: Int) : Int = {
  x*x
}

def bla() = {
  lazy val y: Int = b*b
  println(y)
}
b=4
bla()
