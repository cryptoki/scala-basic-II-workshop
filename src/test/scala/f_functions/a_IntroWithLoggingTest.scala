package f_functions

import org.scalatest.FlatSpec

import scala.annotation.tailrec

class a_IntroWithLoggingTest extends FlatSpec {
  val msg = "The %s of %d is %d."


  def formatResult(name: String, n: Int, f: Int => Int): String = ???

  "message of factorial of 4" should "be 'The factorial of 4 is 24'" in {
    val message: String = ???
    assert(message == "The factorial of 4 is 24")
  }

  "message of fibonacci of 4" should "be 'The fibonacci of 4 is 2'" in {
    val message: String = ???
    assert(message == "The factorial of 4 is 24")
  }



  // already implemented and tested for you
  def factorial(n: Int): Int = {
    @tailrec
    def factorial(n: Int, acc: Int): Int =
      if (n <= 0) acc else factorial(n - 1, n * acc)
    factorial(n, 1)
  }

  def fibonacci(n: Int) : Int = {
    lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map(x => x._1 + x._2)
    fibs.take(n).last
  }

  "factorial of 4 and 10" should "be 24 and 24" in {
    assert(factorial(4) == 24)
    assert(factorial(10) == 3628800)
  }

  "fibonacci of 4 and 10" should "be 2 and 34" in {
    assert(fibonacci(4) == 2)
    assert(fibonacci(10) == 34)
  }
}
