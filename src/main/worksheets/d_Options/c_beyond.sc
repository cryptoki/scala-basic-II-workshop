// which data type has 'a'?
val a= null

// Scala has Null reference type,
// it's only instance is the null reference
val b = null

a eq b
a == b

// Nothing is subtype of every other type
// there exist no instances of this type
val c: Nothing

// and if u see 'Nil' it is an object which extends List
// it represents an empty list
val l = Nil
// not to confuse with null


// Unit is a subtype of AnyVal
// There is only one value of type Unit, (), and it is not
// represented by any object in the underlying runtime system.
// analogous to Java void
val unit = ()
val unitExample = List(2,3,4,5).copyToArray(new Array[Int](4))