class SimpleGreeter {
  val great = "hello world"
  def greet() = println(great)
}
val g = new SimpleGreeter();
g.greet()
class FancyGreet(name : String) {
  def greet() = println(name)
}
val g2 = new FancyGreet("hi")
g2.greet()
class RepeaterGreet(name: String, count: Int = 2) {
  def greet() = {
    for(i <- 1 to count) {
      println(name)
    }
  }
}
val g3 = new RepeaterGreet("hello", 3)
g3.greet()
val g4 = new RepeaterGreet(count = 5, name= "hello bla");
g4.greet()