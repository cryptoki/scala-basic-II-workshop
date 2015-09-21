import java.io.IOException


// TODO -1-  is it a checked or unchecked exception in scala?
// TODO -me-  write an explicit throws for Java
// TODO -me-  show the java <=> scala example
def doAnotherDangerous() = {
  throw new IOException
}

doAnotherDangerous()