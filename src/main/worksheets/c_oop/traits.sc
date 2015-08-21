// traits like JAVA 8 interfaces encapsulate fields and methods
// this enables implementation of thin interfaces
// no constructor
trait InterfaceLikeTrait {
  def someAbstractMethod()
}

// trait mixins != multiple inheritance!!!
// super class in a trait is dynamically bound
// the method to call when calling super methods is determined every time a trait is mixed in

// stackable modification aka decorator pattern

class StringThing(myString: String) {
  override def toString = myString
}

trait Prefix extends StringThing {
  override def toString = "<<< " + super.toString
}

trait Postfix extends StringThing {
  override def toString = super.toString + " >>>"
}

trait LFilter extends StringThing {
  override def toString = {
    val s: String = super.toString
    s.filterNot(_ == 'l')
  }
}

class SomeStringThing(s: String)
  extends StringThing(s: String)
  with LFilter
  with Prefix
  with Postfix

// multiple traits call the same super method but it's only executed once
new SomeStringThing("Hello World").toString

// mix-in can be done during object creation
new StringThing("Fool") with Prefix with Postfix with LFilter

trait BracketFilter extends StringThing {
  override def toString = super.toString.filterNot {
    case '<' | '>' => true
    case _ => false
  }
}

// as super calls are dynamically bound the order of mixin definition influences the result
// ordering of traits influences linearization ordering
// see http://stackoverflow.com/a/32132095/5251660 for comprehensive documentation
// method of leftmost trait is called first
new StringThing("Bar") with Prefix with Postfix with BracketFilter
new StringThing("Bar") with BracketFilter with Prefix with Postfix
