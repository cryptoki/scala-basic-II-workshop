import java.util.Date

import org.joda.time.{Years, DateTime}

case class User(name: String, gender: Option[String],
                 dateOfBirth: Option[Date]) {
  def age1: Option[Int] = {
    dateOfBirth match {
      case Some(dob) => Some(calculateAge(dob))
      case None => None
    }
  }
  def age: Option[Int] = {
    // wenn None, dann wird die Funktion erst gar nicht aufgerufen
    dateOfBirth.map(calculateAge)
  }

  def isMale: Boolean = gender.contains("M")

  def calculateAge(dateOfBirth: Date) = {
    val dob = new DateTime(dateOfBirth)
    val now = new DateTime()
    Years.yearsBetween(dob, now).getYears
  }
}

object User {
}

val johanna = User("johanna", None, None)
val bob = User("bob", Some("M"), Some(new DateTime().minusYears(25).toDate))

johanna.gender.getOrElse("Nicht da")
bob.gender.get
bob.age
johanna.age

bob.isMale
johanna.isMale

