
/**
 * Getters and setters
 *
 * @param budget Is just a parameter
 * @param restaurant Compiler generates a readable field
 * @param howMany Compiler generates a readable field and a setter
 */
class Reservation(budget: Int, val restaurant: String, var howMany: Int)

val res = new Reservation(250, "Il Ritrovo", 12)

// Audience: what is the result?
// res.budget

// Audience: what is the result?
//res.restaurant

// Audience: what is the result?
// res.restaurant = "Curry 36"

// Audience: what is the result?
//res.howMany
//res.howMany = 14

// If a parameter has the var keyword, a public writer method is also generated with
// the parameter’s name as a prefix, followed by _= .
res.howMany
res.howMany = 14
res.howMany_=(16)
res.howMany
