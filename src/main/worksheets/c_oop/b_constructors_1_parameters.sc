import scala.util.Random

/**
 * Constructor with parameter aka class parameter
 *
 * @see [[scala.collection.Seq]]
 */
class ConfigurableLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))
}

val configured = new ConfigurableLunchDecision(
  Seq(
    "Pasta",
    "Curry Wurst",
    "Sandwich"
  )
).decide()
