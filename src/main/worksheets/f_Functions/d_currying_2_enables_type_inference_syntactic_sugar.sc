/**
 * Curried functions enable compiler for type inference
 */
def acceptCurried[T](something: T)(pred: T => Boolean): Boolean = pred(something)


// types in predicate function can be omitted
acceptCurried("Curry")(s => s.length > 0)
acceptCurried("Curry")(_.length > 0)
acceptCurried(15)(i => i > 0)
acceptCurried(15)(_ > 0)


// Type inference is not possible in uncurried version
def accept[T](s: T, pred: T => Boolean): Boolean = pred(s)

accept("Curry", (s: String) => s.length > 0)
accept(15, (i: Int) => i > 0)

// without currying this is not possible:
//accept("Curry", s => s.length > 0)
//accept("Curry", _.length > 0)
//accept(15)(i => i > 0)
//accept(15)(_ > 0)
