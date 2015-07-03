import scala.beans.BeanProperty

class Greet(greeting: String)
object Greet {
  def wordlyGreeting = println("hello")
}
Greet.wordlyGreeting
object model {
  class WorldlyGreeter(greeting: String) {
    def greet() = {
      val wordlyGreeting = WorldlyGreeter.worldify(greeting)
      println(WorldlyGreeter.minAge)
    }
  }

  object WorldlyGreeter {
    val minAge = 18

    def worldify(s: String) : String = {
      println(s"$s world!")
      s"$s world!"
    }
    def apply(s: String) = new WorldlyGreeter(s)
  }
}


model.WorldlyGreeter.worldify("hello")
val wg1 = model.WorldlyGreeter("hello")
wg1.greet()
case class World(@BeanProperty greeting: String)
val v2 = World("hello")
v2.hashCode()


