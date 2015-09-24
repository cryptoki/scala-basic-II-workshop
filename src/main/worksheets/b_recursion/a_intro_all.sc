/**
 * Let's start with a simple example
 */

/* The imperative way - Old school */
val listOfNumbers = Range(1, 15, 3)

// TODO -1-  summarize the values in the list
//           use for loop
var result = 0
for (i <- listOfNumbers)
  result += i

assert(result == 35)

// you can implement it in a recursion manner as well