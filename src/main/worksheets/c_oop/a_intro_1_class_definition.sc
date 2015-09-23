/**
 * Scala is object-oriented and it's always like...write less do more :)
 */
class AClass

val d = new AClass

val isAny = d.isInstanceOf[Any]

class BClass extends AClass

val isA = new BClass().isInstanceOf[AClass]
val isB = new BClass().isInstanceOf[BClass]
