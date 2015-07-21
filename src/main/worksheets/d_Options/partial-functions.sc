def process[A](status: Int, pf: PartialFunction[Int, A]): A = {
  println( "blafoo")
//  pf.applyOrElse(status, throw new Exception())
  if (pf.isDefinedAt(status)) {
    pf.apply(status)
  }
  else {
    println( s"unexpected status $status")
    throw new Exception(s"unexpected status $status")
  }
}
val status = 500
process(status, {
  case 200 => "ok"
  case 404 => "not ok"
})