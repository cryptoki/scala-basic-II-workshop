// reuse of the existing stream example 1,3,5 ..
// TODO -me-  what happend if you print out?
lazy val stream: Stream[Int] = 1 #:: stream.map((x: Int) => {
//  println(s" map $x + 1 = " + (x+2l))
  x+2
})
stream take 4 // foreach(x => println(s"found next: $x"))


// TODO -1-  Is it the same?
val firstValue: Int = 1
lazy val streamLeftAssociative: Stream[Int] =
  streamLeftAssociative.map(x => {
    //  println(s" map $x + 1 = " + (x+1l))
    x+2
  }).#::(firstValue)
streamLeftAssociative take 4 // foreach(x => println(s"found next: $x"))


// TODO -2-  Is it the same?
def streamAsFunction: Stream[Int] = 1 #:: streamAsFunction.map((x: Int) => {
  //  println(s" map $x + 1 = " + (x+1l))
  x+2
})
streamAsFunction take 4 // foreach(x => println(s"found next: $x"))
