
/**
 * Getters and setters
 *
 * @param budget Is just a parameter
 * @param restaurant Compiler generates a readable field
 * @param howMany Compiler generates a readable field and a setter
 */
class Reservation(budget: Int, val restaurant: String, var howMany: Int) {
  def getBudget = budget
}

val lunchReservation = new Reservation(250, "Il Ritrovo", 12)

// TODO: think about audience interaction instead of documenting
// TODO: add parameter with override

// Without "val" or "var" we just define a parameter. Accessing a parameter does not work.
// lunchReservation.budget
lunchReservation.getBudget

lunchReservation.restaurant

// When "val" no setter is generated. Re-assigning a val is not allowed.
// lunchReservation.restaurant = "murks"

// When parameter is declared as a val, the compiler generates
// a private field corresponding to each parameter (a different internal name is used),
// along with a public reader method that has the same name as the parameter.
// If a parameter has the var keyword, a public writer method is also generated with
// the parameter’s name as a prefix, followed by _= .

lunchReservation.howMany
lunchReservation.howMany = 14
lunchReservation.howMany_=(16)
lunchReservation.howMany


// FYI: This is what the compiler generates
class Reservation2(budget: Int, val restaurant: String) {
  def getBudget = budget

  private var _howMany = 12

  def howMany = _howMany

  def howMany_=(newBudget: Int) = _howMany = newBudget

}

