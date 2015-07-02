package b_recursion

import org.scalatest.FlatSpec
import scala.annotation.tailrec

/**
  * Summe der natürlichen Zahlen von 1 bis n
  */
class a_SumNaturalNumbersTest extends FlatSpec {
  def sumNaturalNumber(maximum: Int) : Long = sumNaturalNumberTailRecursive(maximum)

  def sumNaturalNumberImperativ(maximum: Int) : Long = {
    var result: Long = 0
    for ( i <- 1 to maximum) {
      result += i
    }
    result
  }

  def sumNaturalNumberRecurive(maximum: Int) : Long = {
    if (maximum == 0)
      0l
    else
      maximum + sumNaturalNumberRecurive(maximum - 1)
  }

  def sumNaturalNumberTailRecursive(maximum: Int) : Long = {
    @tailrec
    def sumNaturalNumberTailRecursive(maximum: Int, acc: Long) : Long = {
      if (maximum == 0)
        acc
      else
        sumNaturalNumberTailRecursive(maximum - 1, acc + maximum)
    }
    sumNaturalNumberTailRecursive(maximum, 0)
  }

  "sum of natural numbers from 1 to 3" should "be 6" in {
    val count = sumNaturalNumber(3)
    assert(count == 6)
  }

  "sum of natural numbers from 1 to 10" should "be 55" in {
     val count = sumNaturalNumber(55)
     assert(count == 1540)
   }

  "sum of natural numbers from 1 to 100000" should "be 55" in {
    val count = sumNaturalNumber(100000)
    assert(count == 5000050000l)
  }
}
