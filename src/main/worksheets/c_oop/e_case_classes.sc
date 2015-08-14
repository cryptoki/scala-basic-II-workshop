// allow pattern matching without a lot of boilerplate
// easy construction of tree structures

//Case classes can be seen as plain and immutable data-holding objects that should exclusively depend on their constructor arguments.

// easy json handling???

case class EMail(to: String, subject: String, attachments: List[Attachment])


case class Player(name: String, score: Score)

case class Score(game: String, score: Int)

case class Attachment(filename: String)

// Scala compiler adds syntactic convenience
// factory method with classname
// instance creation without new=> compact initialization syntax
val hulk = Player("Hulk", null)
// all parameters implicitly get val => maintained as fields

// defaults for toString, equals, hashCode
// == delegates to equals -> == on case classes compares structurally
Player("Ironman", null) == Player("Ironman", null)

hulk.toString

// objects are immutable
// use copy method to get a copy with changed value
val hulkWithScore = hulk.copy(score = Score("Pacman", 3560))

def sendPromotionMail(player: Player): Boolean = player match {
  case Player(_, null) =>
    print(s"Send EMail to ${player.name} ")
    true
  case _ => false
}

sendPromotionMail(hulk)
sendPromotionMail(hulkWithScore)

def playerLevelPacman(player: Player) = player match {
  case Player(name, Score("Pacman", score)) if score > 3000 => print (s"$name: Super hero")
  case Player(name, Score("Pacman", score)) if score > 6000 => print (s"$name: Intermediate")
  case Player(name, Score("Pacman", _)) => print (s"$name: Beginner")
}


playerLevelPacman(hulkWithScore)
// Question: what happens with Player("One",null) or Player("One",Score("Two", "Pong")
//playerLevelPacman()
playerLevelPacman(hulk)
// case classes are mostly useful for pattern matching => explain how pattern matching would be implemented?
//def validateEmail(mail: EMail): Unit = {
//  mail2 match {
//    case EMail(to, _, _) if to.isEmpty => println("Error, define a recipient.")
//    case EMail(_, _, head :: tail) => println("Found attachment, virus scan necessary.")
//  }
//}


// only drawback is size
// example
case class GitLog(commit: String, author: String, date: String, message: String)
