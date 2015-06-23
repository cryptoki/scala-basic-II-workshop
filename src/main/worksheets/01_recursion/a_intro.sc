/**
 * Fakultät
 * das Produkt aus allen vorkommenden natürlichen Zahlen, von eins beginnend,
 * bis zu einer angegebenen Zahl.
 *
 * Vier Fakultät oder 4! = Ist das Produkt aus 1, 2, 3 und 4, also 24.
 * @param n
 * @return
 */
def factorial(n: Int): Int = {
  if (n == 0)
    1
  else
    n * factorial(n - 1)
}
factorial(4)
// In IDEA wird eine Rekursion durch das Spiegelverkehrte Symbol @ dargestellt.
// -> Im Worksheet gut links neben dem 'def' zu erkennen.

// 4 * factorial(3)
// 3 * factorial(2)
// 2 * factorial(1)
// 1 * factorial(0)
// 1

// = 1
// = 1
// = 2
// = 6
// = 24
