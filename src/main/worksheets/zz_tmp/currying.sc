def add(x: Int, y: Int) : Int = x+y
val add1: (Int, Int) => Int = (x: Int, y: Int) => x+y

val add2: (Int) => (Int) => (Int) =
  (x: Int) => (y: Int) => x+y
val add3: (Int) => (Int) => (Int) =
  (x: Int) => {
    val result = (y: Int) => x+y
    result
  }

add(2,3)
add1(3,4)

val plus10 = add2(10)
plus10(15)

val plus3 = add2(3)
plus3(9)


def add4(x: Int)(y: Int) = x + y
// muss explizit konvertiert werde
// val plus4 = add4(4) => hier noch ein _
val plus4 = add4(4) _


