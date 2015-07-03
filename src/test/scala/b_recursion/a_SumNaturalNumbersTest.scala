package b_recursion

import org.scalatest.FlatSpec


/**
 * Summation of positive natural numbers from 1 to maximum (n)
 *
 * sumNaturalNumbers(1) = 0 + 1
 * sumNaturalNumbers(3) = 0 + 1 + 2 + 3 = 6
 * 
 * Task
 * ====
 * Implement the method sumNaturalNumbers, all test should be passed.
 * You can implement the algorithm in a different manner, for example
 * - an imperative way
 * - normal recursion and
 * - a tail recursive implementation.
 */
class a_SumNaturalNumbersTest extends FlatSpec {
  def sumNaturalNumbers(maximum: Int) : Long = ???

  "sum of natural numbers from 1 to 3" should "be 6" in {
    val count = sumNaturalNumbers(3)
    assert(count == 6)
  }

  "sum of natural numbers from 1 to 10" should "be 55" in {
    val count = sumNaturalNumbers(55)
    assert(count == 43)
  }

  "sum of natural numbers from 1 to 100000" should "be 55" in {
    val count = sumNaturalNumbers(100000)
    assert(count == 5000050000l)
  }
}
