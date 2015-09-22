/**
 * Currying must be used when working with implicit parameter lists.
 *
 * Implicit parameter lists are frequently used to inject dependencies into functions.
 */
def accept(s: String)(implicit pred: String => Boolean): Boolean = pred(s)

implicit val isOink: String => Boolean = s => s == "Oink"

accept("Yeeha")
accept("Oink")

// Show Example code from Play framework project with implicit request