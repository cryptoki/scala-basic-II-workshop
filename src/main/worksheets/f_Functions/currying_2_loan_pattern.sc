import java.io.File
import java.util.Scanner

import scala.util.Try

// loan pattern - loan a resource to a function
def withFile[T](f: File, handler: Scanner => T): Option[T] = {
  val scanner = Try(new Scanner(f))
  try {
    scanner.map(scanner =>
      Some(handler(scanner))
    ).getOrElse {
      println("Could not open file")
      None
    }
  } finally {
    scanner.map { scanner => scanner.close() }
  }
}

withFile(new File("idea.properties"), scanner =>
  scanner.useDelimiter("\\Z").next())