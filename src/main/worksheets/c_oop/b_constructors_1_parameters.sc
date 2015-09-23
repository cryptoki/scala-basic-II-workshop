import scala.util.Random

val food: Seq[String] = Seq(
  "Pasta",
  "Curry Wurst",
  "Sandwich"
)

/**
 * Constructor with parameter aka class parameter
 *
 * @see [[scala.collection.Seq]]
 */
class Lunch(choices: Seq[String]) {
  def decide(): String = choices(Random.nextInt(choices.size))
}

new Lunch(food).decide()
