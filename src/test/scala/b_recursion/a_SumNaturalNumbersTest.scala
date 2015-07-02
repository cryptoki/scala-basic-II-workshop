package b_recursion

import org.scalatest.FlatSpec
import scala.annotation.tailrec

/**
 * Summation of positive natural numbers from 1 to maximum (n)
 *
 * sumNaturalNumbers(1) = 0 + 1
 * sumNaturalNumbers(3) = 0 + 1 + 2 + 3 = 6
 */
class a_SumNaturalNumbersTest extends FlatSpec {
  def sumNaturalNumbers(maximum: Int) : Long = sumNaturalNumbersTailRecursive(maximum)

  def sumNaturalNumbersImperativ(maximum: Int) : Long = {
    var result: Long = 0
    for ( i <- 1 to maximum) {
      result += i
    }
    result
  }

  def sumNaturalNumbersRecurive(maximum: Int) : Long = {
    if (maximum == 0)
      0l
    else
      maximum + sumNaturalNumbersRecurive(maximum - 1)
  }

  def sumNaturalNumbersTailRecursive(maximum: Int) : Long = {
    @tailrec
    def sumNaturalNumbersTailRecursive(maximum: Int, acc: Long) : Long = {
      if (maximum == 0)
        acc
      else
        sumNaturalNumbersTailRecursive(maximum - 1, acc + maximum)
    }
    sumNaturalNumbersTailRecursive(maximum, 0)
  }

  "sum of natural numbers from 1 to 3" should "be 6" in {
    val count = sumNaturalNumbers(3)
    assert(count == 6)
  }

  "sum of natural numbers from 1 to 10" should "be 55" in {
     val count = sumNaturalNumbers(55)
     assert(count == 1540)
   }

  "sum of natural numbers from 1 to 100000" should "be 55" in {
    val count = sumNaturalNumbers(100000)
    assert(count == 5000050000l)
  }
}
