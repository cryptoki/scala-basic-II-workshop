/**
 * Sealed traits can only be extended in the same file as its declaration.
 * The compiler knows every possible subtypes and can reason about it.
 */
sealed trait Answer

class Yes extends Answer

class No extends Answer

val x: Answer = new Yes
// this leads to a compiler warning
x match {
  case answer: No => "No"
}