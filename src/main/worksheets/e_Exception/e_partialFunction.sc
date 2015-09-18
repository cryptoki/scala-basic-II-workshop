/**
 * PartialFunction
 *  - Sub Trait von Function1
 *    - isDefindedAt
 *    - lift
 *  - Erklärung erfolgt im nächsten Kapital
 */

// ====================================
// Intro
// ====================================

val handler: PartialFunction[Throwable, Int] = {
  case m: NumberFormatException => {
    println("I catch u")
    -1
  }
}

// TODO -me- isDefinedAt
//           IllegalArgumentException
//           NumberFormatException
handler.isDefinedAt(new IllegalArgumentException)
handler.isDefinedAt(new NumberFormatException)


// TODO -me- apply NumberFormatException
val result1 = handler.apply(new NumberFormatException("do not use!!!"))
// TODO -me- lift IllegalArgumentException
val result2 = handler.lift(new IllegalArgumentException("do not use!!!"))


// ====================================
// try / Catch
// ====================================

val globalHandler: PartialFunction[Throwable, Int] = {
  case e:Throwable => {
    println(s"danger! '${e.getMessage}'")
    Int.MinValue
  }
}

try {
//  throw new NoSuchElementException("do not use! :)")
  "abc".toInt
}
catch handler.orElse(globalHandler)
