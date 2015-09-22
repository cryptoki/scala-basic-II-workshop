// ====================================
// Null
// ====================================

// TODO -1-  which data type has 'a' for
//           val a = null ?
// TODO -me-  write explizit type val a:...
//            a:... = ...
val a: Null = null
// => won't work! => val a2:Int = null

// Scala has Null reference type,
// the only instance is the null reference
val b: Null = null

// TODO -2-  which value should have == and eq?
val test1 = a eq b
val test2 = a == b

// ====================================
// Nothing
// ====================================

// Nothing is subtype of every other type
// there exist no instances of this type
// TODO -1-  try to assign a value
val c: Nothing

// TODO -2-  which object signature has None?
val none: Option[Nothing] = None

// ====================================
// Nil
// ====================================

// and if u see 'Nil' it is an object which extends List
// it represents an empty list

// TODO -1-  which class/object signature has Nil?
// TODO -me-  switch into the class for empty and Nil
val list = List.empty
val nil = Nil

// TODO -2-  what is the result of nil == list?
val nilTest1 = nil == list
// TODO -3-  what is the result of nil eq list?
val nilTest2 = nil eq list
// not to confuse with null


// ====================================
// Unit
// ====================================
// Unit is a subtype of AnyVal
// There is only one value of type Unit, (), and it is not
// represented by any object in the underlying runtime system.
// analogous to Java void
val simpleUnitVal = ()

// TODO -me-  println something
val unitExample = println("hello world")

// TODO -1-  write a method which delivers unit
def unitMethod = {}