
/**
 * Constructor with constraints
 */
class NoPastaLunchDecision(val choice: String) {
  if (choice == "Pasta")
    throw new IllegalArgumentException("Oh no ... Pasta again!!!")
}

val noPasta = try {
  new NoPastaLunchDecision("Pasta").choice
} catch {
  case e: IllegalArgumentException => new NoPastaLunchDecision("Pizza").choice
}
