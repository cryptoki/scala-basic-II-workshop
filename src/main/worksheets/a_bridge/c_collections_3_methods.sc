val seq1: Seq[Int] = Seq(1,2,3,4,5,6)

// TODO -1-  multiply each value by 2 and
//           sum up every value
val seq1Sum = seq1.map(x => x*2).sum
assert(seq1Sum == 42)

// TODO -me-  bring the synatic sugar
seq1.map((x: Int) => x*2).sum
seq1 map(_*2) sum

// TODO -me-  what is (x: Int) => x*2?
val f = (x: Int) => x*2
seq1.map(f).sum
seq1 map f sum

// +---------------------------------------------
// | TODO -me-  addon => only as reference
// | additional - reference
// +---------------------------------------------
// head / tail
seq1.head
seq1.tail
// some methods
seq1.filter(_ % 2 == 0)
seq1.groupBy(x => x%2)
seq1.reduce((x,y) => x+y)
seq1.partition(_ % 2 == 0)
// zip and map
val seq2: Seq[Int] = seq1.reverse
seq1.zip(seq2).map(x => x._1+x._2)

