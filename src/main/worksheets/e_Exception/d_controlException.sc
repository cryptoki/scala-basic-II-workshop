import scala.util.Success
import scala.util.control.Exception._

// allCatch
val opt1 = allCatch.opt("42".toInt)
val opt2 = allCatch.opt("abc".toInt)

val try1 = allCatch.withTry("abc".toInt)

val either = allCatch.either("42".toInt)


catching(classOf[NumberFormatException]).withApply(x => 3) {
  "avc".toInt
}

val catchy = catching(classOf[NumberFormatException]).withApply(e => 3)
val bla = catchy {
  "42".toInt
}
