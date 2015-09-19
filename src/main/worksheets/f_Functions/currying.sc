import java.io.File
import java.util.Scanner

import scala.util.Try

def sum(x: Int, y: Int) = x + y
def sumCurried(x: Int)(y: Int) = x + y

// curried version of a function takes first parameter and returns a new function
// taking second parameter - not very useful at first glance? :)
sum(1, 2)
sumCurried(1)(2)



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

// currying is required when using parameter lists containing implicit and non-implicit parameters
// http://stackoverflow.com/questions/8063325/usefulness-as-in-practical-applications-of-currying-v-s-partial-application-i

//Second, and more importantly, type inference can usually figure out the function's parameter type, so it does not have to be given at the call site. For instance, if I define a max function over lists like this:

def maxCurried[T](xs: List[T])(compare: (T, T) => Boolean)
//I can call it like this:

maxCurried(List(1, -3, 43, 0))((x, y) => x < y)
//or even shorter:

maxCurried(List(1, -3, 43, 0))(_ < _)
//If I defined max as an uncurried function, this would not work, I'd have to call it like this:

def max[T](xs: List[T], compare: (T, T) => Boolean)
max(List(1, -3, 43, 0), (x: Int, y: Int) => x < y)