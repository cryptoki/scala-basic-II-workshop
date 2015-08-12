package f_functions

import org.scalatest.FlatSpec

import scala.annotation.tailrec

/**
 * Implement isSorted, which checks whether an Array[A] is sorted according to
 * a given comparison function:
 *
 * def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
 */
class b_SortCheck extends FlatSpec {
  val array1: Array[Int] = Array(1, 2, 3)
  val array2: Array[Int] = Array(3, 1, 6, 9)
  val array3: Array[String] = Array("the", "team", "is", "excellent")
  val array4: Array[String] = Array("excellent", "is", "team", "the")

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def isSorted(n: Int, element: A) : Boolean = {
      if (as.length <= n)
        true
      else if (ordered(element, as(n)) == false)
        false
      else
        isSorted(n+1, as(n))
    }

    if (as.length <= 1)
      true
    else
      isSorted(1, as(0))
  }

  "sorted check of array1" should "be true" in {
    val check = isSorted(array1, (x: Int, y: Int) => x < y)
    assert(check == true)
  }

  "sorted check of array2" should "be false" in {
    val check = isSorted(array2, (x: Int, y: Int) => x < y)
    assert(check == false)
  }

  "sorted check of array3" should "be false" in {
    val check = isSorted(array3, (x: String, y: String) => x < y)
    assert(check == false)
  }

  "sorted check of array4" should "be true" in {
    val check = isSorted(array4, (x: String, y: String) => x < y)
    assert(check == true)
  }
}
