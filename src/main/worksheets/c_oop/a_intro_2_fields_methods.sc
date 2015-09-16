import scala.util.Random

/**
 * Class with field and methods
 */
class LunchDecision {
  // a private member
  private val choices: Seq[String] = Seq("Pizza", "Sushi", "Burger")

  // Type inference: remove return type
  // syntactic sugar: remove curly braces
  def decide() = choices(Random.nextInt(choices.size))
}

val lunch: String = new LunchDecision().decide()
