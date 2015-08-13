package c_oop

import play.api.libs.json.Json

case class LogEntry(commit: String)

object LogEntry {
  implicit val jsonReads = Json.reads[LogEntry]
}

case class GitLog(gitlog: Seq[LogEntry])


object GitLog {
  implicit val jsonReads = Json.reads[GitLog]
}
