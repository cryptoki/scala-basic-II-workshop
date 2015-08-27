package gitlog

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{GitLog, LogEntry}
import play.api.libs.json.Json

object GitLogJsonModel {

  /**
   * When working with play applications, case classes are often used
   * to define Data Transfer Objects which hold deserialized Json values.
   *
   * The Json properties are represented by case class members, i.e.
   *
   * {
   * "commit": "16bc9b75cec01eccff8448b6a11e968f1a35e7a7"...
   * }
   *
   * is mapped to property "commit". The case class property must have same type for automatic mapping.
   * Otherwise custom deserializer can be implemented.
   */
  case class LogEntry(commit: String, author: String)

  // TODO: leave out property

  /**
   * Companion objects can be used
   * to define implicit Json deserializer.
   */
  object LogEntry {
    implicit val jsonReads = Json.reads[LogEntry]
  }

  case class GitLog(logEntries: Seq[LogEntry])

  object GitLog {
    implicit val jsonReads = Json.reads[GitLog]
  }

}

object FrontEndJsonModel {

  abstract class User

  // TODO: leave out property
  case class Author(name: String, email: String)

  object Author {
    implicit val jsonWrites = Json.writes[Author]
  }

}

object GitLogService {
  // TODO: do not implement
  def countCommitsOfUser(log: GitLog, author: String): Int = log.logEntries.count(_.author == author)


  /**
   * Hints:
   * - you may use split method of [[String]]
   * - arrays support a takeWhile and dropWhile method
   * - arrays support mkString to join ll elements to a string
   *
   */
  // TODO: do not implement
  def userFrom(logEntry: LogEntry): Author = {
    val splitted = logEntry.author.split(" ")
    val nameParts = splitted.takeWhile(!_.startsWith("<"))
    val email = splitted.dropWhile(!_.startsWith("<"))
    new Author(nameParts.mkString(" "), email(0))
  }

  // TODO: do not implement
  def usersFromLogEntries(logEntries: Seq[LogEntry]): Seq[Author] = logEntries.map(userFrom)

  // TODO: do not implement?
  def user(authors: Seq[Author], name: String): Author = authors.find(_.name == name).get


}

