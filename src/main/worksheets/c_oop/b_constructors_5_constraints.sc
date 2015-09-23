/**
 * Constructor with constraints
 */
class NoPasta(val choice: String) {
  if (choice == "Pasta")
    throw new IllegalArgumentException("Oh no ... Pasta again!!!")
}

new NoPasta("Pizza")
new NoPasta("Pasta")
