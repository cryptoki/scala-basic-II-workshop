package c_oop

import org.scalatest._
import z_example.ScalaGitLog


class a_GitLogSpec extends FlatSpec with Matchers {
  "foo" should "bar" in {
    ScalaGitLog.readLog().asOpt[GitLog] shouldBe defined
  }
}
