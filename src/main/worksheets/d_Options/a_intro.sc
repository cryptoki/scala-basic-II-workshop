import scala.runtime.RichInt

// how could you write a method which delivers
// 3 if parameter 'isSet' is true or a Java like 'NULL'
// if the parameter is false?
def someMethod(isSet: Boolean): RichInt = {
  // Anybody an idea?
  case _ => 3
}
val a = someMethod(true).abs
