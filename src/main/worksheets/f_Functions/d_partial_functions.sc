object RewriteStatusCode extends PartialFunction[Int, Int] {
  override def isDefinedAt(status: Int): Boolean = Seq(500, 503) contains status

  override def apply(status: Int): Int = 404
}

RewriteStatusCode(500)
RewriteStatusCode(1)
RewriteStatusCode.isDefinedAt(1)

// syntactic sugar

val rewriteStatusCode: PartialFunction[Int, Int] = {
  case 500 | 503 => 404
}

rewriteStatusCode(500)
//rewriteStatusCode(501)

// partial function is subtype of function
// lift


// use partial functions everywhere where functions are expected

0 to 10 map {
  case x if x % 2 == 0 => "even"
  case _ => "odd"
}





