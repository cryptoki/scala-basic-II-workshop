package f_functions

import org.scalatest.FlatSpec

/**
 * Implement isSorted, which checks whether an Array[A] is sorted according to
 * a given comparison function:
 *
 * def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
 */
class b_SortCheckTest extends FlatSpec {
  val array1: Array[Int] = Array(1, 2, 3)
  val array2: Array[Int] = Array(3, 1, 6, 9)
  val array3: Array[String] = Array("the", "team", "is", "excellent")
  val array4: Array[String] = Array("excellent", "is", "team", "the")

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = ???

  "sorted check of array1" should "be true" in {
    val check = isSorted(array1, ???)
    assert(check == true)
  }

  "sorted check of array2" should "be false" in {
    val check = isSorted(array2, ???)
    assert(check == false)
  }

  "sorted check of array3" should "be false" in {
    val check = isSorted(array3, ???)
    assert(check == false)
  }

  "sorted check of array4" should "be true" in {
    val check = isSorted(array4, ???)
    assert(check == true)
  }
}
