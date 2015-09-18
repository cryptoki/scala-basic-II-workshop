/**
 * Write less do more!
 */
0 to 10 filter ((x: Int) => x > 2)
0 to 10 filter ((x) => x > 2)
0 to 10 filter (x => x > 2)
0 to 10 filter (_ > 2)

0 to 10 reduce (_ + _)

// you can help the compiler if necessary
val f = (_: Int) + (_: Double) + (_: String)
f(1, 1.2, " wow")