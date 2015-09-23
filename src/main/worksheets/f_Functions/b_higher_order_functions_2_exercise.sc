def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)
def minLength(min: Int): String => Boolean = (s: String) => s.length >= min

// TODO Audience: Write a function literal "minLiteral" which does the same as minLength

// TODO: acceptString("Foo", minLiteral(1))

// Lost in parameter type lists? Type aliases to the rescue!
// TODO: type alias
