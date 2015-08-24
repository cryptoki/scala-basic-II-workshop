import scala.util.Random

/**
 * Scala is object-oriented and it's always like...write less do more :)
 */
class DumpClass

val d = new DumpClass

val isAny = d.isInstanceOf[Any]

class AnotherDumpClass extends DumpClass

val isDump = new AnotherDumpClass().isInstanceOf[DumpClass]
val isAnotherDump = new AnotherDumpClass().isInstanceOf[AnotherDumpClass]

/**
 * Class with field and methods
 */
class LunchDecision {
  // a private member
  private val choices: Seq[String] = Seq("Pizza", "Sushi", "Burger")

  // Type inference: remove return type
  // syntactic sugar: remove curly braces
  def decide() = choices(Random.nextInt(choices.size))
}

val lunch: String = new LunchDecision().decide()
