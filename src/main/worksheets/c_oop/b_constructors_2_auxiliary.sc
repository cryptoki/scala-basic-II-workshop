import scala.util.Random

val food = ("Pasta", "Pizza")

/**
 * Inheritance and Auxiliary constructors
 */
class Lunch(choices: Seq[String]) {
  def decide(): String = choices(Random.nextInt(choices.size))

  //  Restriction:
  //    The primary constructor must be called from every other constructor
  def this(choices: (String, String)) = {
    this(Seq(choices._1, choices._2))
  }

}

new Lunch(food).decide()
