/**
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

// TODO -me-  explain tail recursion


