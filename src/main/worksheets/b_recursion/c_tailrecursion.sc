/**
 * tail recursive (german Endrekursion)
 * https://de.wikipedia.org/wiki/Endrekursion
 *
 * "Eine rekursive Funktion f ist endrekursiv (englisch tail recursive;
 * auch endständig rekursiv, iterativ rekursiv, repetitiv rekursiv), wenn der rekursive
 * Funktionsaufruf die letzte Aktion zur Berechnung von f ist.[1] Vorteil dieser
 * Funktionsdefinition ist, dass kein zusätzlicher Platz zur Verwaltung der Rekursion benötigt wird."
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
 *
 * tail recursion
 * --------------
 * Mathmatics: n! = n * (n-1)!
 *
 * factorial(1, 4)
 * factorial(1*4, 3)
 * factorial(4*3, 2)
 * factorial(12*2, 1)
 * 24
 *
 * The last method call is the last step of the calculation. That is the different between
 * a normal and tail recursion.
 *
 * The Scala compile will be convert a tail recursion into a normal imperative loop manner
 */

// Please implement the a_SumNaturalNumbersTest in a tail recursive manner