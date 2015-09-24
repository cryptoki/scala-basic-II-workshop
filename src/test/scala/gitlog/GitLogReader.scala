package gitlog

import gitlog.GitLogJsonModel.GitLog
import play.api.libs.json.{JsValue, Json}

import scala.io.Source

object GitLogReader {
  /**
   * Read Git log in Json format from file.
   *
   * @param filePath Path to the Json file
   * @return `Some[JsValue]` if json file could be successfully read and transformed, otherwise None
   */
  // TODO -IMPLEMENT-  implement missing error handling
  def readLog(filePath: String): Option[JsValue] = {
    Some(Json.parse(Source.fromFile(filePath).mkString))
  }

  def jsonToObj(jsValue: JsValue): Option[GitLog] = {
    jsValue.asOpt[GitLog]
  }
}
