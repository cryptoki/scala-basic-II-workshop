import scala.util.Random

/**
 * Class with field and methods
 */
class Lunch {
  private val food = Seq("Pizza", "Sushi", "Burger")

  // Public API should have return type
  def decide(): String = food(Random.nextInt(food.size))

}

val lunch = new Lunch().decide()
