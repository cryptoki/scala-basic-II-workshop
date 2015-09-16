import scala.util.Random

/**
 * Inheritance and Auxiliary constructors
 */
class LimitedChoicesLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))

  //  Restriction:
  //    The primary constructor must be called from every other constructor
  def this(choice1: String, choice2: String) = {
    this(Seq(choice1, choice2))
  }
}

val limited = new LimitedChoicesLunchDecision("Pasta", "Pizza").decide()
