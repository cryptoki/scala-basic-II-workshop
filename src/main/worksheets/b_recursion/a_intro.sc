// The imperative way - Old school

val listOfNumbers = Range(1, 15, 3)

// a little bit sugar
1 to 15 by 3 // is the same!
// to -> RichInt (see the bridge section
// by -> Range .. it's only a method


/**
 * Simple example
 * summarize the values in the list
 */
var result = 0
for (i <- listOfNumbers)
  result += i

result
