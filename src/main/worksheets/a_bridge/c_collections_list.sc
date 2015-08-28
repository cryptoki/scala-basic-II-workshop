// a )
// -1- define a list with values 1,2,3,4
val list1: List[Int] = List()

assert(list1.sum == 10)

// -2- define a list with value "b", "c"
val list2: List[String] = List()

assert(list2(0) == "b")
assert(list2(1) == "c")


// -3- append value "a" to the head of list2
val list3 = list2

assert(list3(0) == "a")


// -4- append list2 and list3
val list4 = list2

assert(list4(2) == "a")
