/**
 * For case classes extractors for pattern matching are generated
 */
case class Player(name: String, score: Score = null)

case class Score(game: String, score: Int)

val hulk = Player(name = "Hulk", score = Score("Pacman", 3560))

/**
 * Return the level of a player for a game depending on score ("Super Hero", "Intermediate", "Beginner")
 */
def playerLevel(someGame: String, player: Player): String = ???

val hulkPacmanLevel = playerLevel("Pacman", hulk)

