package gitlog

import org.scalatest.{FunSuite, Matchers}
import play.api.libs.json.JsValue


class GitLogReaderTest extends FunSuite with Matchers {
  test("Returns Some[JsValue] for existing file path") {
    val log = GitLogReader.readLog("src/test/scala/gitlog/scala-gitlog.json")
    assert(log.isDefined)
  }

  test("Returns None for non-existing file path") {
    val log = GitLogReader.readLog("/non/existing/path")
    assert(log.isEmpty)
  }

  test("Converts json to GitLog") {
    val maybeJsValue: Option[JsValue] = GitLogReader.readLog("src/test/scala/gitlog/scala-gitlog.json")
    val gitLog = for {
      jsValue <- maybeJsValue
      gitLog <- GitLogReader.jsonToObj(jsValue)
    } yield gitLog

    assert(gitLog.isDefined)
  }
}
