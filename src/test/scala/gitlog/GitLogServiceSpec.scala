package gitlog

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.{GitLog, LogEntry}
import org.scalatest._
import play.api.libs.json.{JsError, JsNull, JsSuccess, Json}


class GitLogServiceSpec extends FlatSpec with Matchers {

  class GitLogFixture {
    // read gitlog json AST and try to convert into a GitLog instance
    val maybeGitLog: Option[GitLog] =
      GitLogReader.readLog("src/test/scala/gitlog/scala-gitlog.json")
        .getOrElse(JsNull)
        .validate[GitLog] match {
        case error: JsError =>
          println("Errors during Json deserialization " + error.errors)
          None
        case success: JsSuccess[GitLog] => success.asOpt
      }

    maybeGitLog shouldBe defined
    val gitLog: GitLog = maybeGitLog.get
  }


  "Adriaan Moors" should "have made 40 commits" in new GitLogFixture {
    GitLogService.countCommitsOfUser(gitLog, "Adriaan Moors <adriaan.moors@typesafe.com>") shouldBe 40
  }

  "Name and email of an author in LogEntry" should "be splitted into name and email of Author" in {
    GitLogService.authorFromLogEntry(LogEntry(author = "Adriaan Moors <adriaan.moors@typesafe.com>")) shouldBe Author(name = "Adriaan Moors", email = "<adriaan.moors@typesafe.com>")
  }

  "Name and email of an author" should "serialize to Json" in {
    val expectedJson =
      """
        |{
        | "name": "John Doe",
        | "email": "<john.doe@email.com>"
        |}
      """.

        stripMargin

    val author: Author = Author(name = "John Doe", email = "<john.doe@email.com>")

    val authorJson = Json.toJson(author)
    authorJson shouldBe Json.parse(
      expectedJson)
  }

  "Adriaan Moors email" should "be <adriaan.moors@typesafe.com>" in new GitLogFixture {
    val users = GitLogService.authorFromLogEntries(gitLog.logEntries)
    GitLogService.author(users, "Adriaan Moors").email shouldBe "<adriaan.moors@typesafe.com>"
  }

  "For Adriaan Moors" should "40 log entries be found" in new GitLogFixture {
   GitLogService.logEntryByName(gitLog)("Adriaan Moors").size shouldBe 40
  }

  "4 commits" should "have been done on Wed Aug 5 2015" in new GitLogFixture{
    println("perDay = " + GitLogService.logEntryPerDay(gitLog))
    GitLogService.logEntryPerDay(gitLog)("2015-08-05") shouldBe 4
  }
}
