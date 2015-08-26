package c_oop

import gitlog.GitLogJsonModel.GitLog
import gitlog.{GitLogService, GitLogReader}
import org.scalatest._
import play.api.libs.json.{JsError, JsSuccess}


class GitLogModelSpec extends FlatSpec with Matchers {

  class GitLogFixture {

    // read the gitlog json and try to convert into a GitLog instance
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
}
