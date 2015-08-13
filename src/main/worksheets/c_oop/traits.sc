

class StringThing(myString: String) {
  override def toString = myString
}

trait Postfix extends StringThing {
  override def toString = super.toString + " >>>"
}

trait Prefix extends StringThing {
  override def toString = "<<< " + super.toString
}

trait LFilter extends StringThing {
  override def toString = {
    val s: String = super.toString
    s.filterNot(_ == 'l')
  }
}

class SomeStringThing(s: String) extends StringThing(s: String) with LFilter with Postfix with Prefix
new SomeStringThing("Hello World").toString
new StringThing("Fool") with Prefix with Postfix with LFilter
trait BracketFilter extends StringThing {
  override def toString = super.toString.filterNot {
    case '<' | '>' => true
    case _ => false
  }
}

// ordering of traits influences linearization oredering
new StringThing("Bar") with Prefix with Postfix with BracketFilter

new StringThing("Bar") with BracketFilter with Prefix with Postfix
