- represent failures and exceptions with ordinary values
- write higher-order functions that abstract out common patterns of error handling and recovery


# Klassische Variante
Die klassische Variante ist zu JAVA sehr ähnlich und wird wie in JAVA mit try / catch deklariert. In der
catch Klausel werden die Exception mittels catch und pattern Matching selektiert. Es müssen nicht alle
potentiellen Fehler behandelt werden.

=> kein funktionales Paradigma, d.h. keine Verwendbarkeit in map/flatmap usw. (Monaden)

# scala.util.Try
Neu seit Scala 2.10 ist die Klasse Try. Sie beschreibt zwei Ausprägungen Success und Failure. Das Ergebnis vom
Typ Try ist entweder Success oder Failure.
## Success
- triff auf, wenn der auszuführende Code keine Exception geliefert hat
- enthält somit das Resultat / Ergebnis
## Failure
- im Falle eines Fehlers
- enthält den Fehler (Throwable, Exception, ..)

## Verwendung
- Verarbeitung mittels map, flatMap, transform usw. möglich (Monaden)
- getOrElse => Default Werte
- orElse Verkettung möglich 
