package e_exception

import java.io.IOException

import scala.util.Random

object ClassicDangerousProducer {
  // TODO -me-  show what happend in the Java code
  // TODO -me-  show how to solve the problem use scala in java with exceptions
  def doSomethingDangerous(): Int = {
      throw new IOException()
  }
}
