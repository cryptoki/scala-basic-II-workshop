import java.util
import scala.collection.immutable.{ListSet}

// it is JAVA LinkedList!!!
val q: util.List[String] = new util.LinkedList[String]()
q.add("Patricia")
q.remove(0)
q
// TODO -1- remove another one


// TODO -2-  write a similar code with scala immutable ListSet
// operator .-("")  => remove
val l = ListSet("Patricia")
l.-("Patricia").-("jkdhsf")
l.find(x => x == "Patricia")
