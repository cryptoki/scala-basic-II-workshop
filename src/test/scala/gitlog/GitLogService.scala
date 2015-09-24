package gitlog

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{LogEntry, GitLog}

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