import scala.runtime.RichInt

// how could you write a method which delivers
//   => 3 if parameter 'isSet' is true
// OR
//   => a Java like 'NULL' if the parameter is false?
def someMethod(isSet: Boolean): Integer = {
  // Anybody an idea?
  3
}
val a = someMethod(false)
