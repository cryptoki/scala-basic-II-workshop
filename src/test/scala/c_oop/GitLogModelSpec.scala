package c_oop

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.GitLog
import gitlog.{GitLogReader, GitLogService}
import org.scalatest._
import play.api.libs.json.{JsError, JsSuccess, Json}


class GitLogModelSpec extends FlatSpec with Matchers {

  class GitLogFixture {

    // read gitlog json AST and try to convert into a GitLog instance
    val maybeGitLog: Option[GitLog] = GitLogReader.readLog().validate[GitLog] match {
      case error: JsError =>
        println("Errors during Json deserialization " + error.errors)
        None
      case success: JsSuccess[GitLog] => success.asOpt
    }
  }

  "(Sanity check) Deserialization of gitlog Json file" should "produce a GitLog instance" in new GitLogFixture {
    maybeGitLog shouldBe defined

  }

  "Adriaan Moors" should "have made 40 commits" in new GitLogFixture {
    val gitLog: GitLog = maybeGitLog.get
    GitLogService.countCommitsOfUser(gitLog, "Adriaan Moors <adriaan.moors@typesafe.com>") shouldBe 40
  }

  "All members of an author" should "serialize to Json" in {
    val expectedJson =
      """
        |{
        | "name": "John Doe",
        | "email": "<john.doe@email.com>"
        |}
      """.stripMargin

    val authorJson = Json.toJson(Author(name = "John Doe", email = "<john.doe@email.com>"))
    authorJson shouldBe Json.parse(expectedJson)
  }

  "Adriaan Moors email" should "be <adriaan.moors@typesafe.com>" in new GitLogFixture {
    println("GitLogService.usersFromLogEntries(maybeGitLog.get.logEntries).groupBy(_.name) = " + GitLogService.usersFromLogEntries(maybeGitLog.get.logEntries).groupBy(_.name))

    val users = GitLogService.usersFromLogEntries(maybeGitLog.get.logEntries)
    GitLogService.user(users, "Adriaan Moors").email shouldBe "<adriaan.moors@typesafe.com>"
  }


}
