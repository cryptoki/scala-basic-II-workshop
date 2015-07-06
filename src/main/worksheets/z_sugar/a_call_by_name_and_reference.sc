/**
 * there are two ways to pass parameters
 *
 * call by value
 * -------------
 * value 'll pass into the method
 * def some(x: Int) = ???
 *
 * call by name
 * ------------
 * the name 'll pass into the method _AND_ the value 'll evaluated when it's needed
 * def some(x: => Int) = ???
 */

def value(): Int = {
  println("request value")
  1
}

def callByValue(x: Int) = println(s"x1=$x - x2=$x")
def callByName(x: => Int) = println(s"x1=$x - x2=$x")

callByValue(value())
callByName(value())