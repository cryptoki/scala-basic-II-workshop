import scala.util.Random

/**
 * Class with field and methods
 */
class Lunch {
  private val where = Seq("Pizza", "Sushi", "Burger")

  // Public API should have return type
  def decide(): String = where(Random.nextInt(where.size))

}

val lunch = new Lunch().decide()
