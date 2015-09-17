case class Player(name: String, score: Score = null)
case class Score(game: String, score: Int)
// An implicit companion object is created so that "new" is obsolete
val hulk = Player("Hulk")

// Objects are immutable. To get new instances based on each other
// use copy method to get a copy with changed values
val hulkWithScore = hulk.copy(score = Score("Pacman", 3560))
