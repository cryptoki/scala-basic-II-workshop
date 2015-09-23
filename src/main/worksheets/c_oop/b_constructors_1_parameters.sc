import scala.util.Random

/**
 * Constructor with parameter aka class parameter
 *
 * @see [[scala.collection.Seq]]
 */
class Lunch(where: Seq[String]) {
  def decide(): String = where(Random.nextInt(where.size))
}

new Lunch(
  Seq(
    "Pasta",
    "Curry Wurst",
    "Sandwich"
  )
).decide()
