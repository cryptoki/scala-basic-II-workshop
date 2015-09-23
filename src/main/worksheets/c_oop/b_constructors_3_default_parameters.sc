import scala.util.Random

/**
 * Named parameter and default value
 */
class Lunch(choice1: String = "Pasta", choice2: String = "Pizza") {
  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

// Audience: I want Burger instead of Pizza
new Lunch(choice2 = "Burger").decide()