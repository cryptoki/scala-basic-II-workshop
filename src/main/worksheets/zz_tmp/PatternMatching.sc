// http://danielwestheide.com/blog/2012/11/21/the-neophytes-guide-to-scala-part-1-extractors.html
// http://danielwestheide.com/blog/2012/11/28/the-neophytes-guide-to-scala-part-2-extracting-sequences.html
class StringThing(val s: String)

/**
 * Simple extractor
 */
object StringThingExtractor {
  def unapply(st: StringThing): Option[String] = Some(st.s)
}

val matchy = (s: StringThing) => s match {
  case StringThingExtractor("foo") => "call me foo"
  case _ => "no foo"
}

val isFoo = matchy(new StringThing("foo"))
val isNotFoo = matchy(new StringThing("foobar"))

/**
 * Boolean extractor
 */
object FooExtractor {
  def unapply(st: StringThing): Boolean = if (st.s.toLowerCase == "foo") true else false
}

new StringThing("foo") match {
  case st@FooExtractor() => "got foo"
  case _ => "no foo"
}

/**
 * Extract sequences
 */
object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names = name.trim.split(" ")
    if (names.forall(_.isEmpty)) None else Some(names)
  }
}

def greetWithFirstName(name: String) = name match {
  case GivenNames(firstName, _*) => "Good morning, " + firstName + "!"
  case _ => "Welcome! Please make sure to fill in your name!"
}

greetWithFirstName("John Doe")

object Names {
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names: Seq[String] = name.trim.split(" ")
    if (names.size < 2) None
    else Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}

def greet(fullName: String) = fullName match {
  case Names(lastName, firstName, _*) => "Good night, " + firstName + " " + lastName + "!"
  case _ => "Welcome! Please make sure to fill in your name!"
}

greet("John J Samuel Doe")
greet("")