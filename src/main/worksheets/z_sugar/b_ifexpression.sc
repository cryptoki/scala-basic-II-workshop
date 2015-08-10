// an if expression has the same syntax as in Java, BUT
// it also returns a value
def simpleExample(value: Boolean): Int = {
  (if(value) 2 else 3) * 5
}

val result1 = simpleExample(true)
val result2 = simpleExample(false)