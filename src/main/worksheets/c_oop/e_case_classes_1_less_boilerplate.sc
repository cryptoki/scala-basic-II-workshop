/**
 * Case classes prevent a lot of boilerplate code because the compiler implicitly generates a lot.
 *
 * They're often used as data-holding objects without behavior.
 */
case class Player(name: String, score: Score = null)

case class Score(game: String, score: Int)

// An implicit companion object is created so that "new" is obsolete
val hulk = Player("Hulk")

// Constructor parameters are exported
val hulksName = hulk.name

// default implementation for toString
val hulkToString = hulk.toString

// default implementations for structurally comparison via equals
val isIronman = Player("Ironman", null) == Player("Ironman", null)