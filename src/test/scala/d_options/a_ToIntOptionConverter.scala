package d_options

import org.scalatest.FlatSpec

class a_ToIntOptionConverter extends FlatSpec {

  def toInt(input: String): Option[Int] = ???

  "toInt conversion of 3" should "be Some(3)" in {
    val convert = toInt("3")
    assert(convert == Some(3))
  }

  "toInt conversion of 3sd3" should "be None" in {
    val convert = toInt("3sd3")
    assert(convert == None)
  }

  "toInt conversion of empty" should "be None" in {
    val convert = toInt("")
    assert(convert == None)
  }
}
