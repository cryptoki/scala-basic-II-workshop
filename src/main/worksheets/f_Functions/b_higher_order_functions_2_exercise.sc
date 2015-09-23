def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)
def minLength(min: Int): String => Boolean = (s: String) => s.length >= min

// TODO Audience: Write a function literal which does the same as minLength
val minLiteral: (Int) => (String => Boolean) = (minimum) => (s => s.length >= minimum)
// val minLiteralVariant = (minimum: Int) => ((s: String) => s.length >= minimum)

acceptString("Foo", minLiteral(1))

// Lost in parameter type lists? Type aliases to the rescue!
type Predicate = String => Boolean

val hasLength: Int => Predicate = i => s => s.length == i

acceptString("FooBar", hasLength(6))

