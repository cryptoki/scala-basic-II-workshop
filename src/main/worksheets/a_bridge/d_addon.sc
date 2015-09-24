val listForTesting: List[Int] = List()
listForTesting match {
  case head +: Nil =>
    println(s"-1- found head ${head}")

  case head +: head2 +: tail if (head2 == 3) =>
    println(s"-2- found head=$head head2=$head2 with ${tail.length}")

  case head +:tail =>
    println(s"-3- found tail with length tail length ${tail.length}")

  case Nil => println("Empty")

  case _ => println("bla")
}