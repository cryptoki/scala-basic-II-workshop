package gitlog

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

object GitLogReader {
  /**
   * Read Git log in Json format from file.
   *
   * @param filePath Path to the Json file
   * @return `Some[JsValue]` if json file could be successfully read and transformed, otherwise None
   */
  def readLog(filePath: String): Option[JsValue] = {
    Some(Json.parse(Source.fromFile(filePath).mkString))
  }
}
