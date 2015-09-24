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

assert(factors(6) == List(2, 3))
assert(factors(8) == List(2, 2, 2))
assert(factors(18) == List(2, 3, 3))
assert(factors(27) == List(3, 3, 3))



