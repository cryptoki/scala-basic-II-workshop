/**
 * Scala is object-oriented and it's always like...write less do more :)
 */
class DumpClass

val d = new DumpClass

val isAny = d.isInstanceOf[Any]

class AnotherDumpClass extends DumpClass

val isDump = new AnotherDumpClass().isInstanceOf[DumpClass]
val isAnotherDump = new AnotherDumpClass().isInstanceOf[AnotherDumpClass]
