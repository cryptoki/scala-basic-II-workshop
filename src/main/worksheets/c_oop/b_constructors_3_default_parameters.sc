import scala.util.Random

/**
 * Named parameter and default value
 */
class TolerantLunchDecision(choice1: String = "Pasta", choice2: String = "Pizza") {
  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

val tolerant = new TolerantLunchDecision(choice2 = "Burger").decide()