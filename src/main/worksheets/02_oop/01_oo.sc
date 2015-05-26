import scala.util.Random


/*
 * Class with field and method
 */
class LunchDecision {
  val choices: Seq[String] = Seq("Pizza", "Sushi", "Burger")

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

/*
 * Constructor with parameter
 */
class ConfigurableLunchDecision(choices: Seq[String]) {
  def decide() = choices(Random.nextInt(choices.size))
}

val confDecision = new ConfigurableLunchDecision(Seq("Pasta", "Curry Wurst", "Sandwich"))
confDecision.decide()

/*
 * Additional constructors
 */
class LimitedChoicesLunchDecision(choices: Seq[String]) {

  //  Restriction:
  //    The primary constructor must be called from every other constructor
  //
  //  Workaround:
  //    Use companion objects with factory methods
  //
  def this(choice1: String, choice2: String, choice3: String) = {
    this(Seq(choice1, choice2, choice3))
  }

  def decide() = choices(Random.nextInt(choices.size))

}

val limitedChoicesLunchDecision = new LimitedChoicesLunchDecision("Pasta", "Pizza", "Burger")
limitedChoicesLunchDecision.decide()

/*
 * Named parameter and default value
 */
class TolerantLunchDecision(choice1: String = "Pasta", choice2: String = "Pizza") {

  def decide() = Seq(choice1, choice2)(Random.nextInt(2))
}

val tolerantLunchDecision = new TolerantLunchDecision(choice2 = "Burger")
tolerantLunchDecision.decide()

// TODO: getters and setters, visibility, var, val in constructor parameters + visibility

/*
 * Constructor with constraints
 */
class NoPastaLunchDecision(choices: Seq[String]) {
  if (choices.contains("Pasta"))
    throw new IllegalArgumentException("Please no Pasta again!!!")
}

val noPasta = new NoPastaLunchDecision(Seq("Pizza", "Pasta"))
