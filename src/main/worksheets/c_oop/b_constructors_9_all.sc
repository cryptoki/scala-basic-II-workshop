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

/**
 * Inheritance and Auxiliary constructors
 */
class LunchRestricted(choices: Seq[String]) {
  def decide(): String = choices(Random.nextInt(choices.size))

  //  Restriction:
  //    The primary constructor must be called from every other constructor
  def this(choices: (String, String)) = {
    this(Seq(choices._1, choices._2))
  }

}

new LunchRestricted("Pasta", "Curry Wurst").decide()

/**
 * Named parameter and default value
 */
class LunchDefault(choice1: String = "Pasta", choice2: String = "Pizza") {
  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

// Audience: I want Burger instead of Pizza
new LunchDefault(choice2 = "Burger").decide()


/**
 * Getters and setters
 *
 * @param budget Is just a parameter
 * @param restaurant Compiler generates a readable field
 * @param howMany Compiler generates a readable field and a setter
 */
class Reservation(budget: Int, val restaurant: String, var howMany: Int)

val res = new Reservation(250, "Il Ritrovo", 12)
// Audience: what is the result?
// TODO: res.budget
// TODO: res.budget = 150

// Audience: what is the result?
// TODO: res.restaurant
// TODO: res.restaurant = "Souples"

// Audience: what is the result?
// TODO: res.howMany
// TODO: res.howMany = 14
// TODO: res.howMany_=(16)

// If a parameter has the var keyword, a public writer method is also generated with
// the parameter’s name as a prefix, followed by _= .
res.howMany
res.howMany = 14
res.howMany_=(16)
res.howMany


/**
 * Constructor with constraints
 */
class NoPasta(val choice: String) {
  if (choice == "Pasta")
    throw new IllegalArgumentException("Oh no ... Pasta again!!!")
}

new NoPasta("Pizza")
new NoPasta("Pasta")
