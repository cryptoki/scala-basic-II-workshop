package d_options

import scala.io.Source
import org.scalatest.FlatSpec

class b_SumNumbersTest extends FlatSpec {

  def readFile(name: String): String = {
    val file = Source.fromFile(name)
    try
      file.mkString
    finally
      file.close()
  }

  def sumNumbers(input: String): Int = ???

  "simple text with 1 and 2" should "be 3 as sum" in {
    val sum = sumNumbers("simple text with 1 and 2 should deliver?")
    assert(sum == 3)
  }

  "simple text with no numbers" should "be 0 as sum" in {
    val sum = sumNumbers("simple text with NO numbers :)")
    assert(sum == 0)
  }

  "read the crazy file" should "be xyz as sum" in {
    val input = readFile("src/test/scala/d_options/crazy.txt")
    val sum = sumNumbers(input)
    assert(sum == 85)
  }
}
