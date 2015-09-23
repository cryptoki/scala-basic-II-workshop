// ====================================
// Range
// ====================================

// '<-' expression is called GENERATOR in Scala
// it generates individual values from a collection
// each loop generates a NEW val i

// TODO -me-  define a range from 0 to 10
val range1 = Range(0, 10, 1)

// TODO -1- sum up each value in the range 0+1+2.... = __
//          IMPORTANT: use a for loop
var result: Int = 0
for(i <- range1)
  result+= i

println(s"the result is $result")
assert(result == 45)


// ====================================
// Implicit
// ====================================

/**
 * Implicit type conversion '0' to RichInt
 * RichInt methods:
 *   def to (end: Int, step: Int): Inclusive
 *   def to (end: Int): Inclusive
 *   def until (end: Int, step: Int): Range
 *   def until (end: Int): Range */
// TODO -me-  define a range inclusive and exclusive
val range2 = 0 to 10      // Range.Inclusive
val range3 = 0 until 10   // Range

// TODO -me-  for loop with range and sequence
for (i <- Range(0,10,2)) println(i)
val seq = Seq(2,3,10,20)
for (i <- seq) println(i)

Range.apply(0, 10)
