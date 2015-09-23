// val test: Stream[Int] = 1 #:: 2 => Compiler Error => #:: is an operator from Stream
// #:: ConsWrapper => Cons.apply => fügt dem Stream ein Head Element hinzu
// => Initial Stream ist empty => 2+Empty Stream => 1 + Stream(2) => danach zuweisen des Ergebnis
//    an test
// => Stream ist gefüllt mit 1, 2 Elemente
// => Bauvorschrift führt jetzt den vorhergehenden Schritt wieder aus
// => 1 + 2 + Stream(1,2)

// Definition eines Streams welcher sich selbst rekursiv erstellt
// => Bauvorschrift
// #:: rechts assoziativer Operator cons
// 0 + 1 + stream
// tupel und hinzufügen durch tupel Addition
val fibonacci : Stream[Int]=
  0 #:: 1 #:: fibonacci.zip(fibonacci.tail).map(x => {
//    println(x)
    x._1 + x._2
  })
fibonacci take 10 foreach println



// Faktorzerlegung
def factors(n: Long): List[Long] =
  (2 to math.sqrt(n).toInt).find(n % _ == 0)
    .map(i => i.toLong :: factors(n / i)).getOrElse(List(n))

factors(6)



