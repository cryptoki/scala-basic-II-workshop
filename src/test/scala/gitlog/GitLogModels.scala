package gitlog

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
  // TODO -IMPLEMENT- => write complete LogEntry case class
  case class LogEntry(commit: String, author: String, date: String, message: String, stat: Option[Seq[Statistic]] = None)

  // TODO -IMPLEMENT- => write case class for stat entry in JSON
  case class Statistic(insertions: String, deletions: String, path: String)

  object Statistic {
    implicit val jsonReads = Json.reads[Statistic]
  }

  /**
   * Companion objects can be used
   * to define implicit Json deserializer.
   */
  // DO NOT MODIFY
  object LogEntry {
    implicit val jsonReads = Json.reads[LogEntry]
  }

  // DO NOT MODIFY
  case class GitLog(logEntries: Seq[LogEntry])

  // DO NOT MODIFY
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


