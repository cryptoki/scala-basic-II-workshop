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

// Objects are immutable. To get new instances based on each other
// use copy method to get a copy with changed values
val hulkWithScore = hulk.copy(score = Score("Pacman", 3560))
// For case classes extractors for pattern matching are generated
def sendPromotionMail(player: Player): Boolean = player match {
  case Player(_, null) => true
  case _ => false
}
val shouldSendMailToHulk = sendPromotionMail(hulk)
val shouldSendMailToHulkWithScore = sendPromotionMail(hulkWithScore)
def playerLevelPacman(someGame: String, player: Player) = player match {
  case Player(name, Score(game, score)) if game == someGame && score > 6000 => "Super Hero"
  case Player(name, Score(game, score)) if game == someGame && score > 3000 => "Intermediate"
  case Player(name, Score(game, _)) => "Beginner"
}
val hulkPacmanLevel = playerLevelPacman("Pacman", hulkWithScore)

/**
 * FYI: Example of a simple extractor which must be implemented for non- case classes
 */
class StringThing(val s: String)
object StringThingExtractor {
  def unapply(st: StringThing): Option[String] = Some(st.s)
}

new StringThing("foo") match {
  case StringThingExtractor("foo") => "call me foo"
  case _ => "no foo"
}