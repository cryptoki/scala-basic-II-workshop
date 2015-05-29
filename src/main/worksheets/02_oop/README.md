#### Themen
* classes
 - fields
 - methods
 - constructor with parameters
 - check constraints in constructor
 - auxiliary constructors
 - named parameters and default values
 - abstract
 - final
 - getters/setters vs. val/var someSetter_=
 - each parameter is declared as a val, the compiler generates a private field corresponding to each parameter (a different internal name is used), along with a public reader method that has the same name as the parameter
 - Scala supports single inheritance, not multiple inheritance. A child (or derived) class can have one and only one parent (or base) class. The sole exception is the root of the Scala class hierarchy, Any, which has no parent.
 
 - private[this]
 
overriding methods??? 
 
* singletons
 - methods + method invocations
 - companion object
 - factory objects
 
* case classes
 - implicit companion object
 - pattern matching
 - json
 - implicit parameters
 - implicit conversions
 
* traits and mixins
 - simple trait
 - multiple inheritance
 - sealed trait
 - pattern matching
 - traits can inherit classes
 - trait vs. abstract
 
* Bonus
 - package object
 - Type Hierarchy
 - Predef