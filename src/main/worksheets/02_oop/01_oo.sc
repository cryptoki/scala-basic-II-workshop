import scala.util.Random


/**
 * Class with field and methods
 */
class LunchDecision {
  private val choices: Seq[String] = Seq("Pizza", "Sushi", "Burger")

  // last statement in a block defines the return statement
  def decide0(): String = {
    choices(Random.nextInt(choices.size))
  }

  // syntactic sugar: remove curly braces
  def decide1(): String = choices(Random.nextInt(choices.size))

  // This does not work. Without braces first expression determines return value
  //  def decide1(): String =
  //    println("Get ready for lunch")
  //    choices(Random.nextInt(choices.size))

  // Type inference: remove return type
  def decide2() = choices(Random.nextInt(choices.size))
}

val decision = new LunchDecision()
decision.decide0()
decision.decide1()
decision.decide2()

/**
 * Constructor with parameter
 */
class ConfigurableLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))
}

val confDecision = new ConfigurableLunchDecision(Seq("Pasta", "Curry Wurst", "Sandwich"))
confDecision.decide()

/**
 * Auxiliary constructors
 */
class LimitedChoicesLunchDecision(choices: Seq[String]) {
  //  Restriction:
  //    The primary constructor must be called from every other constructor
  def this(choice1: String, choice2: String, choice3: String) = {
    this(Seq(choice1, choice2, choice3))
  }

  def decide() = choices(Random.nextInt(choices.size))

}

val limitedChoicesLunchDecision = new LimitedChoicesLunchDecision("Pasta", "Pizza", "Burger")
limitedChoicesLunchDecision.decide()

/**
 * Named parameter and default value
 */
class TolerantLunchDecision(choice1: String = "Pasta", choice2: String = "Pizza") {
  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

val tolerantLunchDecision = new TolerantLunchDecision(choice2 = "Burger")
tolerantLunchDecision.decide()

/**
 * Constructor with constraints
 */
class NoPastaLunchDecision(val choice: String) {
  if (choice == "Pasta")
    throw new IllegalArgumentException("Oh no ... Pasta again!!!")
}

val noPasta = try {
  new NoPastaLunchDecision("Pasta")
} catch {
  case e: IllegalArgumentException => new NoPastaLunchDecision("Pizza")
}

noPasta.choice

/**
 * Getters and setters
 */
class Reservation(budget: Int, val restaurant: String, var howMany: Int) {
  def getBudget = budget
}

val lunchReservation = new Reservation(250, "Il Ritrovo", 12)

// This does not work. Without val or var we just define a parameter
// fuchs.param
lunchReservation.getBudget

lunchReservation.restaurant
// This does not work. With val no setter is generated
// fuchs.readableField = "murks"

// when parameter is declared as a val, the compiler generates a private field corresponding to each parameter (a different internal name is used), along with a public reader method that has the same name as the parameter.
// if a parameter has the var keyword, a public writer method is also generated with the parameter’s name as a prefix, followed by _= .

lunchReservation.howMany
lunchReservation.howMany = 14
lunchReservation.howMany_=(16)


/*
 * Optional part begins
 */

// This is what the compiler generates
class Reservation2(budget: Int, val restaurant: String) {
  def getBudget = budget

  private var _howMany = 12

  def howMany = _howMany

  def howMany_=(newBudget: Int) = _howMany = newBudget

}

/*
 * Optional part ends
 */

