// collections api
// use a lot of HOF, if we use map, filter and ... we have to give
// a function as argument

// define a function for even numbers
val even = (x: Int) => (x % 2 == 0)

val evenExplicit: (Int => Boolean) = (x:Int) => (x % 2 == 0)
val evenAnotherOne: (Int => Boolean) = _ % 2 == 0

val evenWithoutSugar: Function1[Int, Boolean] = _ % 2 == 0
val evenWithoutSugarExplicit = new Function[Int, Boolean] {
  override def apply(x: Int): Boolean = x % 2 == 0
}

def evenAsDef(x: Int): Boolean = x % 2 == 0

val list = 0 to 10
val list2 = list.filter(even)
val list3 = list.filter(evenAsDef)

// => the compile does NOT know the type
// for use in list, u don't need it
// val evenWontWork = _ % 2 == 0
list.filter(_ % 2 == 0)


// monomorphic function => functions that operate on only
// one type of data