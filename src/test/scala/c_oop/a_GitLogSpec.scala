package c_oop

import c_oop.GitLogJsonModel.GitLog
import org.scalatest._
import play.api.libs.json.{JsError, JsSuccess, JsValue}
import z_example.ScalaGitLog


class a_GitLogSpec extends FlatSpec with Matchers {
  "Adriaan Moors" should "have made 40 commits" in {
    val gitLog: JsValue = ScalaGitLog.readLog()

    val maybeGitLog: Option[GitLog] = gitLog.validate[GitLog] match {
      case error: JsError => {
        println("Errors during Json deserialization " + error.errors)
        None
      }
      case success: JsSuccess[GitLog] => success.asOpt
    }

    maybeGitLog shouldBe defined

    GitLogService.commitsByUser(maybeGitLog.get)("Adriaan Moors <adriaan.moors@typesafe.com>").size shouldBe 40

  }
}
