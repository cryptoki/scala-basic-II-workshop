import scala.util.control.Exception._

catching(classOf[NumberFormatException]).withApply(x => 3) {
  "avc".toInt
}

val catchy = catching(classOf[NumberFormatException]).withApply(e => 3)
val bla = catchy {
  "42".toInt
}
