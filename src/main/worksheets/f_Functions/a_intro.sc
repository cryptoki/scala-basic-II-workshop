import scala.annotation.tailrec

// it could be very useful to write a function that accepts
// other functions as arguments, this is called
// higher order functions (HOF)


// define a function 'doSomeCool' which takes as argument a
// number(Int) and a function
// println "I'm so cool, the result is " with the result of
// the function

def doSomeCool(n: Int, f: Int => Int) = {
  println("I'm so cool, the result is " + f(n))
}

// okay, lets start to use
// audience -> different typing options
doSomeCool(3, _*2)
doSomeCool(3, x => x*2)
doSomeCool(3, (x:Int) => x*2)
doSomeCool(3, (x:Int) => {
  x*2
})
def productOfTwo(x: Int) : Int = x*2
doSomeCool(3, productOfTwo)

// it's common convention to use names like f, g, h for
// parameter to a HOF
// very short names, even one-letter names, because HOFs are so
// general that they have no opinion on what the argument should
// actually do



// lets try .. section f_function/IntroWithLoggingTest