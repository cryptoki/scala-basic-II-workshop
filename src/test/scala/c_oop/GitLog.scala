package c_oop

import c_oop.GitLogJsonModel.GitLog
import play.api.libs.json.Json

object GitLogJsonModel {

  /**
   * When working with play applications, case classes are used
   * to define Data Transfer Objects which hold deserialized Json values.
   *
   * The Json properties are represented by case class members,i.e.
   *
   * {
   * "commit": "16bc9b75cec01eccff8448b6a11e968f1a35e7a7"...
   * }
   *
   * is mapped to property "commit"
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

object GitLogService {
  def commitsByUser(log: GitLog) = log.logEntries.groupBy(_.author)
}

