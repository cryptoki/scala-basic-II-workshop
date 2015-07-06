# Mathematisches Beispiel - Berechnung der Fakultät einer natürlichen Zahl
## Imperativer Ansatz
```scala
def factorial(n: Int): Int {
    var acc = 1
    for (i <- 2 to n) {
        acc *= i
    }
    acc
}
```

## Recursion
*Besonderheiten*

* zwingend Rückgabetyp angeben => Scala Compiler beschwert sich sonst
* Tail Call Optimization
  
  - Gefahr von Stack Overflow, wenn die Rekursion "zu tief" geht
  - Methode die 'tail recursive' ist, d.h. der rekursive Aufruf den letzten Ausführungsschritt darstellt, wandelt der Scala Compiler die Rekursion in eine Schleife um
  - Annotation '@tailrec' 





# let's start
* vorhandene worksheets ausdünnen und pushen
* Tests dafür noch schreiben
* Übungsaufgabe erstellen
* Dokumentation
  * Unterteilung in Abschnitte
  * Kleine Hilfe

  
# Theorie
(Bedarf der Aufbereitung, was davon genutzt wird und was nicht)




http://daily-scala.blogspot.de/2010/01/streams-2-stream-construction.html
git clone https://github.com/fpinscala/fpinscala.git