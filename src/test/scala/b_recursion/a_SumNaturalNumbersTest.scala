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
 * You can implement the algorithm in a different manner., for example
 * - an imperative way
 * - normal recursion and
 * - a tail recursive implementation.
 */
class a_SumNaturalNumbersTest extends FlatSpec {

  /**
   * imperative implementation - old school with loops
   */
  def sumNaturalNumbersImperative(maximum: Int) : Long = ???

  /**
   * normal recursion
   */
  def sumNaturalNumbersRecursive(maximum: Int) : Long = ???

  /**
   * implement a tail recursive algorithm
   */
  def sumNaturalNumbersTailRecursive(maximum: Int) : Long = ???



  "sum of natural numbers from 1 to 3 for the imperative algorithm" should "be 6" in {
    val count = sumNaturalNumbersImperative(3)
    assert(count == 6)
  }
  "sum of natural numbers from 1 to 3 for the recursive algorithm" should "be 6" in {
    val count = sumNaturalNumbersImperative(3)
    assert(count == 6)
  }
  "sum of natural numbers from 1 to 3 for the tail recursive algorithm" should "be 6" in {
    val count = sumNaturalNumbersImperative(3)
    assert(count == 6)
  }


  "sum of natural numbers from 1 to 10 for the imperative algorithm" should "be 55" in {
    val count = sumNaturalNumbersImperative(55)
    assert(count == 43)
  }
  "sum of natural numbers from 1 to 10 for the recursive algorithm" should "be 55" in {
    val count = sumNaturalNumbersImperative(55)
    assert(count == 43)
  }
  "sum of natural numbers from 1 to 10 for the tail recursive algorithm" should "be 55" in {
    val count = sumNaturalNumbersImperative(55)
    assert(count == 43)
  }


  "sum of natural numbers from 1 to 100000 for the imperative algorithm" should "be 5000050000l" in {
    val count = sumNaturalNumbersTailRecursive(100000)
    assert(count == 5000050000l)
  }
  "sum of natural numbers from 1 to 100000 for the recursive algorithm" should "be 5000050000l" in {
    val count = sumNaturalNumbersTailRecursive(100000)
    assert(count == 5000050000l)
  }
  "sum of natural numbers from 1 to 100000 for the tail recursive algorithm" should "be 5000050000l" in {
    val count = sumNaturalNumbersTailRecursive(100000)
    assert(count == 5000050000l)
  }
}
