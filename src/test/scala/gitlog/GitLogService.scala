package gitlog

import java.text.SimpleDateFormat
import java.util.{Calendar, Locale, Date}

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{LogEntry, GitLog}

object GitLogService {
  val simpleDateFormat: SimpleDateFormat =
    new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy ZZZZ", Locale.UK)
  val convertSimpleDateFormat : SimpleDateFormat =
    new SimpleDateFormat("yyyy-mm-dd")

  def countCommits(log: GitLog) : Int = log.logEntries.size

  // TODO: do not implement
  def countCommitsOfUser(log: GitLog, author: String): Int = log.logEntries.count(_.author == author)

  def countOfContributer(log: GitLog): Int = log.logEntries.groupBy(x => x.author).keys.size

  def logEntryPerDay(log: GitLog): Map[String, Int] = {
    log.logEntries.groupBy(x => {
      convertSimpleDateFormat.format(simpleDateFormat.parse(x.date))
    }).map(x => (x._1, x._2.size))
  }

  def logEntryByName(log: GitLog, author: String) : Map[String, Seq[LogEntry]] = {
    log.logEntries.groupBy(x => {
      val author = userFromLogEntry(x)
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
  // TODO: do not implement
  def userFromLogEntry(logEntry: LogEntry): Author = {
    val splitted = logEntry.author.split(" ")
    val nameParts = splitted.takeWhile(!_.startsWith("<"))
    val email = splitted.dropWhile(!_.startsWith("<"))
    new Author(nameParts.mkString(" "), email(0))
  }

  // TODO: do not implement
  def usersFromLogEntries(logEntries: Seq[LogEntry]): Seq[Author] = logEntries.map(userFromLogEntry)

  // TODO: do not implement?
  def user(authors: Seq[Author], name: String): Author = authors.find(_.name == name).get


}