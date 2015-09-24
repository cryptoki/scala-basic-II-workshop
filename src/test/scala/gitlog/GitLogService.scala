package gitlog

import java.util.Locale

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{GitLog, LogEntry}
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

object GitLogService {


  def countCommits(log: GitLog): Int = log.logEntries.size

  // TODO: do not implement
  def countCommitsOfUser(log: GitLog, author: String): Int = log.logEntries.count(_.author == author)

  def countOfContributer(log: GitLog): Int = log.logEntries.groupBy(x => x.author).keys.size

  val inputFormatter: DateTimeFormatter = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss yyyy Z").withLocale(Locale.ENGLISH)
  val outputFormatter: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)

  /**
   * Use [[inputFormatter]] and [[outputFormatter]] to get a [[Map]] of number of commits per day
   */
  def logEntryPerDay(log: GitLog): Map[String, Int] = {
    log.logEntries.groupBy(x => {
      val jodatime: DateTime = inputFormatter.parseDateTime(x.date)
      outputFormatter.print(jodatime)
    }).map(x => (x._1, x._2.size))
  }

  /**
   * Return a map of log entries per name
   */
  def logEntryByName(log: GitLog): Map[String, Seq[LogEntry]] = {
    log.logEntries.groupBy(x => {
      val author = authorFromLogEntry(x)
      author.name
    })
  }

  /**
   * Hints:
   * - you may use split method of [[String]]
   * - arrays support a takeWhile and dropWhile method
   * - arrays support mkString to join ll elements to a string
   *
   */
  // TODO: do not implement Done
  def authorFromLogEntry(logEntry: LogEntry): Author = {
    val splitted = logEntry.author.split(" ")
    val nameParts = splitted.takeWhile(!_.startsWith("<"))
    val email = splitted.dropWhile(!_.startsWith("<"))
    new Author(nameParts.mkString(" "), email(0))
  }

  // TODO: do not implement Done
  def authorFromLogEntries(logEntries: Seq[LogEntry]): Seq[Author] = logEntries.map(authorFromLogEntry)

  // TODO: do not implement? Done
  def author(authors: Seq[Author], name: String): Author = authors.find(_.name == name).get


}