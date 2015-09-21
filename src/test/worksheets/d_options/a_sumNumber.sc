def toInt(input: String): Option[Int] = {
  try {
    Some(input.toInt)
  }
  catch {
    case _:Throwable => None
  }
}

def sumNumbers(input: String): Int = {
  input.split(" ").flatMap(toInt(_)).sum
}

assert(sumNumbers("5 Katzen laufen über den Rasen und jagen 2 Mäuse und einen Vogel") == 7)