# Gitlog Example App
This example simulates backend parts of a web application which is used to visualize information from Git logs.

The simulated backend gets Git logs from a source in Json format. For optimal performance the backend should send as few
data as possible. Data conversions in the frontend shouldn't be necessary.

## Content
 * The package [/src/test/scala/gitlog](/src/test/scala/gitlog) contains all files of the example app. Parts of these files must be changed to fix failing tests
 * [/src/test/scala/gitlog/scala-gitlog.json](/src/test/scala/gitlog/scala-gitlog.json) Example Json data. *Must not be changed to fix tests.*
 * [/src/test/scala/gitlog/GitLogReader](/src/test/scala/gitlog/GitLogReader.scala) Reads example content and converts it to a JsValue.
 * [/src/test/scala/gitlog/GitLogModels](/src/test/scala/gitlog/GitLogModels.scala) DTOs and transformation logic.

  


## Example App Ideas

### Option Teil
* read stats object
* extends case classes with Options

#### Statistics
* # of commits
* # of commits contributers
* Commits per Day
* # of contributers without double names (some contributers have multiple email addresses)
  * combination of forname and surename is anough for unique identifiction
* Contributers for a specific file
  * genASM.scala
  * Imports.scala
* Modifications per file, i.e. Inserts und Deletions
