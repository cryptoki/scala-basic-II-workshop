// allow pattern matching without a lot of boilerplate
// easy construction of tree structures

// easy json handling???

case class Something(a: String, b: Boolean, c: Int)

// Scala compiler adds syntactic convenience

// factory method with classname
// instance creation without new
val some = Something("1234", true, 3)

// all parameters implicitly get val => maintained as fields
println("some.c = " + some.c)

// defaults for toString, equals, hashCode
// == delegates to equals -> == on case classes compares structurally
Something("1", true, 4) == Something("1", true, 4)


some.hashCode()
some.toString


// objects are immutable
// use copy method to get a copy with changed value
some.copy(a = "4321")


// pattern matching

// only drawback is size

// example
case class GitLog(commit: String, author: String, date: String, message: String)
