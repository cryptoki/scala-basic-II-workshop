class Person(val firstName: String, lastName:String, var age:Int = 20) {
  def fullName() = firstName + " " + lastName

  override def toString: String = fullName()
}

val obama = new Person("Barack", "Obama");
obama.fullName()

// => Benutzung von firstName und lastName muss im class val mit angegeben werden
obama.firstName
// geht nicht, weil kein val
// obama.lastName

// geht nicht!
//obama.firstName = "bla"
obama.age
obama.age = 51
obama.age

class Person2(val firstName: String, lastName:String) {
  def fullName() = firstName + " " + lastName

  private var _age = 0
  def age = _age
  def age_=(newAge: Int) = {
    println(s"set value $newAge")
    _age = newAge
  }
}
val obama2 = new Person2("Barack", "Obama")
// => funktion wenn nicht private obama2._age = 15
obama2.age = 2
obama2.age_=(30)
