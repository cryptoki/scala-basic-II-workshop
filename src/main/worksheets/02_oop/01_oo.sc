import scala.util.Random


/**
 * Class with field and method
 */
class LunchDecision {
  val choices = Seq("Pizza", "Sushi", "Burger")

  def decide() = choices(Random.nextInt(choices.size))
}

val decision = new LunchDecision()
decision.decide()

/**
 * Constructor with parameter
 */
class ConfigurableLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))
}

val confDecision = new ConfigurableLunchDecision(Seq("Pasta", "Curry Wurst", "Sandwich"))
confDecision.decide()

/**
 * Invariants
 */
class NoPastaLunchDecision(choices: Seq[String]) {
  if (choices.contains("Pasta")) {
    throw new IllegalArgumentException("Please no Pasta again!!!")
  }

  def decide() = choices(Random.nextInt(choices.size))
}

val noPasta = new NoPastaLunchDecision(Seq("Pizza", "Pasta"))

