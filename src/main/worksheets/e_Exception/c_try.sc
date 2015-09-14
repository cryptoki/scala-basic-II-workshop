import scala.util.{Try, Success, Failure}
import scala.util.control.Exception._
val convert: Try[Integer] = Try {
  "abc".toInt
}
convert match {
  case Success(result) => println(s"Yipee $result")
  case Failure(exc) => println(s"Buhh $exc")
}

val catchy = catching(classOf[NumberFormatException]).withApply(e => 3)
val bla = catchy {
  "42".toInt
}



