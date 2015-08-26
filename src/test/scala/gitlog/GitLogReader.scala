package gitlog

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

object GitLogReader {
  def readLog(): JsValue = {
    Json.parse(Source.fromFile("src/test/scala/gitlog/scala-gitlog.json").mkString)
  }
}
