import scala.util.control.Exception._

// TODO -me-  write handler
val test5: Int = ???

// TODO -1-  can u identify the analogy?
val test6: Int = try {
  "sb".toInt
}
catch {
  case _: NumberFormatException => 1
}

assert(test5 == test6)