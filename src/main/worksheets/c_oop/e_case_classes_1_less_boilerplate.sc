/**
 * Case classes prevent a lot of boilerplate code because the compiler implicitly generates a lot.
 *
 * They're often used as data-holding objects without behavior.
 */
case class Player(name: String, score: Score = null)

case class Score(game: String, score: Int)

// An implicit companion object is created so that "new" is obsolete
// TODO: instance

// Constructor parameters are exported
// TODO: access member

// default implementation for toString
// TODO: toString

// default implementations for structurally comparison via equals
val isIronman = ???