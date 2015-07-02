/**
 * Erklärung
 * Operatoren welche mit einem ':' Enden, sind die Ausdrücke von recht nach links zu lesen!
 * #:: rechts assoziativer Operator cons
 * 1 + stream
 * stream.map(x -> x*2)
 */
val simpleStream: Stream[Int] = 1 #:: simpleStream.map(x => x*2)
//simpleStream take 10 foreach println