package b_recursion

import org.joda.time.DateTime
import org.scalatest.FlatSpec

import scala.annotation.tailrec

class z_OrderingOfSequenceTest extends FlatSpec {

  case class GitEntry(hash: String, time: DateTime)
  val testData1= Seq(
    GitEntry("jhdsbfjd", new DateTime(2015, 2, 10, 0, 0)),
    GitEntry("jbdsf", new DateTime(2015,3,15, 0, 0)),
    GitEntry("hjköo", new DateTime(2015, 6, 30, 0, 0)),
    GitEntry("jkhdsf", new DateTime(2015,8,20, 0, 0)))

  val testData2= Seq(
    GitEntry("jhdsbfjd", new DateTime(2015, 2, 10, 0, 0)),
    GitEntry("jbdsf", new DateTime(2015,3,15, 0, 0)),
    GitEntry("hjköo", new DateTime(2015, 2, 28, 0, 0)),
    GitEntry("jkhdsf", new DateTime(2015,8,20, 0, 0)))

  @tailrec
  final def isIncreasingTimeline(entries: Seq[GitEntry]): Boolean = {
    entries match {
      case Nil => true
      case x1 :: Nil => true
      case x1 :: x2 :: tail => x1.time.isBefore(x2.time) && isIncreasingTimeline(x2 +: tail)
    }
  }

  "increasing timeline of testData1" should "be true" in {
    assert(isIncreasingTimeline(testData1) == true)
  }

  "increasing timeline of testData2" should "be false" in {
    assert(isIncreasingTimeline(testData2) == false)
  }
}
