import scala.util.control.Exception._

val catchy = catching(classOf[NumberFormatException]).withApply(e => 3)
val bla = catchy {
  "42".toInt
}
