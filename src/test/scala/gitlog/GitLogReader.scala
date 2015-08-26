package gitlog

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

/**
 * Read Json example file and provide content as Json AST in form of a [[JsValue]]
 */
object GitLogReader {
  def readLog(): JsValue = {
    Json.parse(Source.fromFile("src/test/scala/gitlog/scala-gitlog.json").mkString)
  }
}
