val l = (1 to 10)

l.reduce((a: Int, b: Int) => a+b)

l.fold(50)((a,b)=>a+b)


val a = Array(1.0, 2.0, 3.0, 4.0, 5.0)

l ++ a