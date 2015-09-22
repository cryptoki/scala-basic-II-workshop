# Options
#### Intro
* idea to use the java null hell
* how could u solve cases if something is only optional?

#### Java
* return null
* throw an exception
* the caller has been the responsibility to handle these exceptions (null validation or try/catch)
  * null -> NullPointerException hell
  * checked vs. unchecked exception and how to handle

#### Solution
* Methoden, die nur partiell definierte Ergebnisse liefern, dies mit jedem Ergebnis mitzuteilen
* Some[R] einzige Subklasse von Option[+R], wobei der Typ Parameter R den Typ des eigentlichen Ergebnisses
  festhält
* None ist ein Singleton Objekt, abgeleitet von Option[Nothing] -> stellt somit den Typ sicheren null dar
* Vorteile
  * Behandlung wird explizit erzwungen Some/None -> Pattern Matching / else / ..
  * Option bietet zahlreiche Methoden mit denen man das Ergebnis auswerten kann

#### Methoden
* getOrElse

# @me
* flüssiger durch die Sachen durch, noch vorher in mein Kopf klären

# Feedback
* wann benutze ich was?
* intro => elvis Beispiel weg werfen und gleich mit Map anfangen
* roten Pfaden noch prüfen und etwas klarer von der Struktur warum ich wohin gehe
