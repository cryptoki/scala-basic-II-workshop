Scala-Workshop: Basics - II
===========================

## Content
* the package [/src/main/worksheets] contains all worksheets
* the package [/src/test/worksheets] the corresponding tests to the worksheets




Inspired by [https://github.com/yanns/scala-workshop](https://github.com/yanns/scala-workshop)

## Source Package
Scala worksheets as supported by [IntelliJ IDEA](https://www.jetbrains.com/idea/) contain all explanatory material. 

## Test Package
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
  

#### Resources
* Daniel Westheide: The Neophyte's Guide to Scala (https://leanpub.com/theneophytesguidetoscala)
* Scala levels: beginner to expert, application programmer to library designer
 - http://www.scala-lang.org/old/node/8610
* Twitter Scala School
 - https://twitter.github.io/scala_school/
* Twitter Effective Scala (Idiomatic Scala) 
 - http://twitter.github.io/effectivescala/
* Idiomatic Scala Question on Stackoverflow
 - http://stackoverflow.com/questions/11359784/good-examples-of-idiomatic-scala-code


#### Agenda

##### Intro
* 30min
* 09:00 - 09:30

##### Recursion
* 45min (1h 15min)
* 09:30 - 10:15

##### Break
* 10:15 - 10:30

##### OOP
* 1h 45min (1h 45min)
* 10:30 - 12:15

##### Lunch Break
* 12:15 - 13:15

##### Options
* 45min (1h 45min)
* 13:15 - 14:00

##### Exception
* 45min (2h 45min)
* 14:00 - 14:45

##### Break
* 14:45 - 15:00

##### Functions
* 60min (2h 45)
* 15:00 - 16:00

##### Abschluss + Break
* 16:00 - 16:15

##### Example App
* 16:15 - 17:00