import scala.util.{Try, Success, Failure}
import scala.util.control.Exception._

// the old known Int converter
val convert: Try[Int] = Try {
  "abc".toInt
}

// Failure and Success
convert match {
  case Success(result) => println(s"Yipee $result")
  case Failure(exc) => println(s"Buhh $exc")
}

val a1 = convert.flatMap(x => Try(3))
val a2 = convert.transform(x => Try(x+1), e => Try(2))

val catchy = catching(classOf[NumberFormatException]).withApply(e => 3)
val bla = catchy {
  "42".toInt
}



