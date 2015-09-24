package gitlog

import gitlog.FrontEndJsonModel.Author
import gitlog.GitLogJsonModel.GitLog
import org.scalatest._
import play.api.libs.json.{JsError, JsNull, JsSuccess, Json}


class GitLogModelSpec extends FlatSpec with Matchers {

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

  "All members of an author" should "serialize to Json" in {
    val expectedJson =
      """
        |{
        | "name": "John Doe",
        | "email": "<john.doe@email.com>"
        |}
      """.stripMargin

    val author: Author = Author(name = "John Doe", email = "<john.doe@email.com>")

    val authorJson = Json.toJson(author)
    authorJson shouldBe Json.parse(expectedJson)
  }

  "Adriaan Moors email" should "be <adriaan.moors@typesafe.com>" in new GitLogFixture {
    val users = GitLogService.usersFromLogEntries(gitLog.logEntries)
    GitLogService.user(users, "Adriaan Moors").email shouldBe "<adriaan.moors@typesafe.com>"
  }


}
