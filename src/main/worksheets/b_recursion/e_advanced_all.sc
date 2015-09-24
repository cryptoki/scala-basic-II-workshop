// !!!!!!!!!!!!!!!!
// !! only addon !!
// !!!!!!!!!!!!!!!!

// ====================================
// Fibonacci
// ====================================

// TODO -1-  implement fibonacci algorithm with streams
// reminder of head::tail and
// zip
val fibonacci : Stream[Int]= ???


// ====================================
// Factoring
// ====================================

// TODO -1-  please implement an algorithm which factoring
//           a number
// input   | factoring
// 3       | 3
// 4       | 2, 2
// 6       | 2, 3
// 8       | 2, 2, 2
// 18      | 2, 3, 3
// 27      | 3, 3, 3
def factors(n: Long): List[Long] =
  (2 to math.sqrt(n).toInt).find(n % _ == 0)
    .map(i => i.toLong :: factors(n / i)).getOrElse(List(n))

factors(6)



