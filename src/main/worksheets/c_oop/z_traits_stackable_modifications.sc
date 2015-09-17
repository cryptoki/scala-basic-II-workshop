/**
 * Traits are mixins. No multiple inheritance is involved:
 *
 * - The trait super class is dynamically bound
 * - The method to call when calling super methods is determined every time a trait is mixed-in
 *
 */
class StringThing(myString: String) {
  override def toString = myString
}

trait Prefix extends StringThing {
  override def toString = "<<< " + super.toString
}

trait Postfix extends StringThing {
  override def toString = super.toString + " >>>"
}

class DecoratedStringThing(s: String)
  extends StringThing(s: String)
  with Prefix
  with Postfix

/**
 *
 * Multiple traits call the same super method
 * but it's only executed once when traits overwrite and call
 * one and the same super method.
 *
 */
val decoratedStringThing = new DecoratedStringThing("Hello World")

trait BracketFilter extends StringThing {
  override def toString = super.toString.filterNot {
    case '<' | '>' => true
    case _ => false
  }
}

/**
 * As super calls are dynamically bound the order of mixin definition influences the result (linearization).
 *
 * Method of leftmost trait is executed first
 *
 * @see [[http://stackoverflow.com/a/32132095/5251660]] for a comprehensive documentation
 */
val guessResult1 = new StringThing("Bar") with Prefix with Postfix with BracketFilter
val guessResult2 = new StringThing("Bar") with BracketFilter with Prefix with Postfix

