// '<-' expression is called GENERATOR in Scala
// it generates individual values from a collection
// each loop generates a NEW val i
for (i <- 0 until 10) println(i) // Range
for (i <- 0 to 10) println(i) // Range.Inclusive

/**
 * Implicit type conversion '0' to RichInt
 * RichInt methods:
 *   def to (end: Int, step: Int): Inclusive
 *   def to (end: Int): Inclusive
 *   def until (end: Int, step: Int): Range
 *   def until (end: Int): Range */
val range = 0 to 10

for (i <- Range(0,10,2)) println(i)
val seq = Seq(2,3,10,20)
for (i <- seq) println(i)

Range.apply(0, 10)
