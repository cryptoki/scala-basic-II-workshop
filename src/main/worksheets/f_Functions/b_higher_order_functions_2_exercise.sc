def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

// TODO Audience: How to write minLength and maxLength as function literals?
// hint: look at different implementations of sum to have examples
val sum1 = (x: Int, y: Int) => x + y
val sum2: (Int, Int) => Int = (x, y) => x + y

val minLiteral: Int => String => Boolean = minimum => s => s.length >= minimum
// variant: val minLiteral = (minimum: Int) => (s: String) => s.length >= minimum
val maxLiteral: Int => String => Boolean = maximum => s => s.length <= maximum
// variant: val maxLiteral = (max: Int) => (s: String) => s.length <= max

acceptString("Foo", minLiteral(1))
acceptString("Foo", maxLiteral(2))


// Lost in parameter type lists? Type alias to the rescue!
type Predicate = String => String => Boolean

val is: Predicate = oneString => otherString => oneString == otherString

acceptString("FooBar", is("FooBar"))

