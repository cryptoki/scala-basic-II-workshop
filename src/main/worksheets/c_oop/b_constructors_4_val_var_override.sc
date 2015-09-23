
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
// TODO: res.budget

// Audience: what is the result?
// TODO: res.restaurant

// Audience: what is the result?
// TODO: res.restaurant = "Curry 36"

// Audience: what is the result?
// TODO: res.howMany
// TODO: res.howMany = 14
// TODO: res.howMany_=(16)
