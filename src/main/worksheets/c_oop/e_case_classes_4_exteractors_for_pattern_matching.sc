/**
 * FYI: Example of a simple extractor which must be implemented for non- case classes
 */
class StringThing(val s: String)

object StringThing {
  def unapply(st: StringThing): Option[String] = Some(st.s)
}

new StringThing("foo") match {
  case StringThing("bla") => "call me foo"
  case _ => "no foo"
}
