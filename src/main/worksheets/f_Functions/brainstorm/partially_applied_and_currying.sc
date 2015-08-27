import java.io.File
import java.util.Scanner

import scala.util.Try

def withFile[T](f: File)(handler: Scanner => T): Option[T] = {
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

// Advantages:
//  readability
//  type inference can figure out function parameter type

withFile(new File("idea.properties")) { scanner =>
  scanner.useDelimiter("\\Z").next()
}

// currying is required when using parameter lists containing implicit and non-implicit parameters
// http://stackoverflow.com/questions/8063325/usefulness-as-in-practical-applications-of-currying-v-s-partial-application-i