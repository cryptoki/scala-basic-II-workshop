package b_recursion

import org.scalatest.FlatSpec


/**
 * Summe der natürlichen Zahlen von 1 bis n
 */
class a_SumNaturalNumbers extends FlatSpec {
  def sumNaturalNumber(maximum: Int) : Long = ???

  "sum of natural numbers from 1 to 3" should "be 6" in {
    val count = sumNaturalNumber(3)
    assert(count == 6)
  }

  "sum of natural numbers from 1 to 10" should "be 55" in {
    val count = sumNaturalNumber(55)
    assert(count == 43)
  }

  "sum of natural numbers from 1 to 100000" should "be 55" in {
    val count = sumNaturalNumber(100000)
    assert(count == 5000050000l)
  }
}
