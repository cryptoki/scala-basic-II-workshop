package z_example

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

object ScalaGitLog {
  def readLog(): JsValue = {
    Json.parse(Source.fromFile("src/test/scala/z_example/scala-gitlog.json").mkString)
  }
}
