import java.io.File
import java.util.Scanner

import scala.util.Try

//Currying is mostly used if the second parameter section is a function
// or a by name parameter. This has two advantages. First, the function argument
// can then look like a code block enclosed in braces. E.g.


def withFileCurried[T](f: File)(handler: Scanner => T): Option[T] = {
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

// curried version of a function looks like built in control structure
withFileCurried(new File("idea.properties")) { scanner =>
  scanner.useDelimiter("\\Z").next()
}