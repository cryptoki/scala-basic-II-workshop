/**
 * Curried functions enable compiler for type inference
 */
// TODO: acceptCurried


// types in predicate function can be omitted
// TODO: syntactic sugar

// Type inference is not possible in uncurried version
// TODO: accept uncurried

// without currying this is not possible:
//accept("Curry", s => s.length > 0)
//accept("Curry", _.length > 0)
//accept(15)(i => i > 0)
//accept(15)(_ > 0)
