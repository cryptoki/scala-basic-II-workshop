import java.text.{ParsePosition, SimpleDateFormat}
import java.util.{Locale, Date}

case class LogEntry(commit: String, author: String, date: String, message: String, stat: Option[Seq[Statistic]] = None)

case class Statistic(insertions: String, deletions: String, path: String)


val simpleDateFormat: SimpleDateFormat =
  new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy ZZZZ", Locale.UK)

// Mon Aug 10 15:39:33 2015 +0200
val bla = simpleDateFormat.format(new Date())
val blub = simpleDateFormat.parse(bla)
simpleDateFormat.format(blub)
simpleDateFormat.format(simpleDateFormat.parse("Thu Sep 24 16:25:28 2015 +0200"))