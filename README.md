scala-Workshop: Basics - II
===========================

Inspired by [https://github.com/yanns/scala-workshop](https://github.com/yanns/scala-workshop)

## Source package
Scala worksheets as supported by [IntelliJ IDEA](https://www.jetbrains.com/idea/) contain all explanatory material. 

## Test package
Contains small exercises in form of [Scala Test](http://www.scalatest.org/) tests.  

### Content
 * The package [/src/test/scala/gitlog](/src/test/scala/gitlog) contains all files of the example app. Parts of these files must be changed during the
 workshop to fix failing tests
 * [/src/test/scala/gitlog/scala-gitlog.json](/src/test/scala/gitlog/scala-gitlog.json) Example Json data. *Must not be changed to fix tests.*
 * [/src/test/scala/gitlog/GitLogReader](/src/test/scala/gitlog/GitLogReader.scala) Reads example content and converts it to a JsValue. *Must not be changed to fix tests.*
 * [/src/test/scala/gitlog/GitLogModels](/src/test/scala/gitlog/GitLogModels.scala) DTOs and transformation logic.
 * Other packages contain test code 

### Gitlog Example App
This example simulates backend parts of a web application which is used to visualize information from Git logs.

The simulated backend gets Git logs from a source in Json format. For optimal performance the backend should send as few
data as possible. Data conversions in the frontend shouldn't be necessary.
  


TODO: remove following parts

#### Prefix für Themen
a_
b_

#### Aufgaben
* Sub Themen finden
* Zeitschätzung für einzelne Bereiche
* Worksheets vorbereiten
* Eine Übungsaufgabe mit fertigen Tests
* Markdown in jedem Bereich


#### Fragen
* Tooling - Gehört das / macht das Part I?
* REPL, SBT -> macht das Part I?
* scalatest  ->  http://scalatest.org/user_guide/selecting_a_style
  * Könnte man überlegen, etwas Varianz in die Tests zu bringen. Ist aber nicht Inhalt des Kurses
* IDEA
* SBT

#### Resourcen
* Scala levels: beginner to expert, application programmer to library designer
 - http://www.scala-lang.org/old/node/8610
* Twitter Scala School
 - https://twitter.github.io/scala_school/
* Twitter Effective Scala (Idiomatic Scala) 
 - http://twitter.github.io/effectivescala/
* Idiomatic Scala Question on Stackoverflow
 - http://stackoverflow.com/questions/11359784/good-examples-of-idiomatic-scala-code


#### Zeit Management
##### Intro
* 30min
09 - 09:30 Uhr
##### Rekursion
* 45min (1h 15)
09:30 - 10:30 Uhr
Pause 10:45 UHr
##### OOP
* 2 Stunden
10:45 - 12:45 Uhr
Pause 13:45 Uhr
##### Options
* __ (2h)
(14:30 Uhr)
##### Exception
* __ (2h 45)
(15:15 Uhr)
Pause 15:30 Uhr
##### Functions
* __ (2h 45)
16:15 Uhr
##### Beispiel
* __ 45min
=> Finish 17:00 Uhr