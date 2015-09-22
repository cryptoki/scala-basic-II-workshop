import java.io.File
import java.util.Scanner

import scala.util.Try


/**
 * Loan pattern: Loan a resource to a function
 *
 * Here without currying
 */
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

val properties = withFile(new File("idea.properties"), scanner =>
  scanner.useDelimiter("\\Z").next())