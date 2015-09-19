// let's repeat some basics

// ====================================
// variable
// ====================================
// var/val

// a )
// TODO -1- define a constant variable 'a' with value 5
// TODO -2- reassign the value with 3
val a: Int = 1

// b )
// TODO -1- define a variable 'b' with value 10
// TODO -2- reassign the value with 12
var b: Int = 2
b = 3


// ====================================
// methods
// ====================================

// a )
// TODO -1-  define a method with an Int parameter named 'x'
//           and calculates 'x*x'
def quadrat(x: Int) : Int = {
  x*x
}

// ====================================
// lazy
// ====================================
var x = 3
def example() = {
  val a = x*x
  lazy val b = x*x

  x=25
  println(s"a=$a - b=$b")
}
example()


// ====================================
// call by name / call by value
// ====================================
def fibonacci(x: Int): Int = {
  println(s"cost a lot of time for $x !!!")
  433494437
}

// TODO -me-  define a method 'doSomething' which takes
//            a as CallByValue and b as CallByName
def doSomething(a: Int, b: => Int) = {}

// TODO -1-  what happend if u call the method with
//           fibonacci(43) and fibonacci(3243244)
doSomething(fibonacci(43), fibonacci(3243244))
