// <- Ausdruck wird in Scala als Generator bezeichnet
// generiert individuelle Werte aus einer Collection zur Verwendung in einem Ausdruck
// Bei jedem Durchlauf wird eine neue val i erzeugt!
for (i <- 0 until 10) println(i) // Range
for (i <- 0 to 10) println(i) // Range.Inclusive

/** Implizite Typkonvertierung zu RichInt und RichInt sind folgende Methoden definiert:
 * def to (end: Int, step: Int): Inclusive
 * def to (end: Int): Inclusive
 * def until (end: Int, step: Int): Range
 * def until (end: Int): Range */
val range = 0 to 10

for (i <- Range(0,10,2)) println(i)
val seq = Seq(2,3,10,20)
for (i <- seq) println(i)

Range.apply(0, 10)
