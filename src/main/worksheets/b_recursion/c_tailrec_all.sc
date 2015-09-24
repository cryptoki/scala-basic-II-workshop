// ====================================
// Definition
// ====================================

/**
 * tail recursive (german Endrekursion)
 * https://de.wikipedia.org/wiki/Endrekursion
 *
 * "Eine rekursive Funktion f ist endrekursiv (englisch tail recursive;
 * auch endständig rekursiv, iterativ rekursiv, repetitiv rekursiv),
 * wenn der rekursive Funktionsaufruf die letzte Aktion zur Berechnung
 * von f ist.[1] Vorteil dieser Funktionsdefinition ist, dass kein
 * zusätzlicher Platz zur Verwaltung der Rekursion benötigt wird."
 * [1] https://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html
 *
 * normal recursion
 * ----------------
 * factorial(4)
 * (* 4 (factorial(3)))
 * (* 4 (* 3 (factorial(2))))
 * (* 4 (* 3 (* 2 (factorial(1)))))
 * (* 4 (* 3 (* 2 (* 1 (factorial(0))))))
 * (* 4 (* 3 (* 2 (* 1 (1)))))
 * (* 4 (* 3 (* 2 (1))))
 * (* 4 (* 3 (2)))
 * (* 4 (6))
 * 24
 */


// TODO -me-  explain
/* tail recursion
 * --------------
 * factorial(1, 4)
 * factorial(1*4, 3)
 * factorial(4*3, 2)
 * factorial(12*2, 1)
 * 24
 */

/* The last method call is the last step of the
 * calculation. That is the different between
 * a normal and tail recursion.
 *
 * The Scala compile will be convert a tail recursion
 * into a normal imperative loop manner
 */


// ====================================
// Exercise
// ====================================

import scala.annotation.tailrec

// imperative
def factorialImperative(n: Long): Long = {
  var result: Long = 1
  for (i: Long <- 1l to n)
    result *= i
  result
}
factorialImperative(4)

// normal recursion
def factorialRecursion(n: Long): Long =
  if (n == 0)
    1
  else
    n * factorialRecursion(n - 1)
factorialRecursion(4)

// TODO -1-  implement a tail recursion for factorial
// tail recursion
def factorialTailRecursion(n: Long, acc: Long): Long =
  if (n == 0)
    acc
  else
    factorialTailRecursion(n - 1, acc * n)
factorialTailRecursion(4, 1)

// TODO -2-  implement a tail recursion with only one parameter
// tail recursion with inner method and annotation
def factorialTailRecursion(n: Long): Long = {
  // to use the tailrec annotation you have to import scala.annotation.tailrec
  @tailrec
  def factorialTailRecursion(n: Long, acc: Long): Long =
    if (n == 0)
      acc
    else
      factorialTailRecursion(n - 1, acc * n)

  factorialTailRecursion(n, 1)
}
factorialTailRecursion(4)
