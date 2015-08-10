import java.text.SimpleDateFormat
import java.util.Date

object MyImplicits {
  implicit def strToDate(str: String): Date = new SimpleDateFormat("yyyy-mm-dd").parse(str)

}

object Model {
  case class Person(name: String)
}

object  MyController {
  import MyImplicits._

  println(strToDate("2014-03-22").getTime / 1000l)
  println("2014-03-22".getTime / 1000l)

  def callPerson(p: Model.Person) = {
    println(s"hello ${p.name}")
  }

  callPerson(Model.Person("yann"))
}

