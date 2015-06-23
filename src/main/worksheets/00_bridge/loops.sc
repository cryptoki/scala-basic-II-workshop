val array1 = "scala is fun yeah".split(" ")
array1.length

var i = 0
while (i < array1.length) {
  println(array1(i))
  i+=1
}

val array2 = "scala is even more fun".split(" ")
i = 0
while (i < array2.length) {
  if (i != 0) {
    print(" ")
  }
  println(array2(i))
  i+=1
}

array2.foreach(println(_))
array2 foreach println
array2.foreach(a => println(a))
array2.foreach((a: String) => println(a))

for (elem <- array2) {
  println(elem)
}

