/**
 * Scala doesn't know static members but supports definition of singleton objects.
 */
object AStandaloneObject {
  def apply() = {
    "Syntactic sugar: apply() is called"
  }

  def aMethod() = {
    "Hi"
  }
}

AStandaloneObject()
AStandaloneObject.aMethod()
AStandaloneObject.isInstanceOf[AnyRef]
