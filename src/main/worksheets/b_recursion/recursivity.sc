import scala.annotation.tailrec

def factorial(n: BigInt): BigInt =
  if (n == 0) 1 else n*factorial(n-1)

// StackOverflow!!!
// factorial(10000)

// Tail Recursion => Scala optimiert, als wäre es wie eine Schleife
def factorialScala(n: BigInt) : BigInt = {
  @tailrec
  def loop(acc: BigInt, n: BigInt):BigInt = {
    if (n == 0) acc
    else loop(acc*n, n-1)
  }
  loop(1,n)
}
factorialScala(10000)