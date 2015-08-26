package gitlog

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

  abstract class User {
    def createFrom(logEntry: LogEntry): User
  }

  case class Author(name: String) extends User {
    override def createFrom(logEntry: LogEntry) = ???
  }

}

object GitLogService {
  def countCommitsOfUser(log: GitLog, author: String): Int = log.logEntries.count(_.author == author)
}

