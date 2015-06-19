Type less do more!

#### Topics
* 01_classes_constructors_fields_methods.sc
 - classes
 - fields
 - methods
 - instance creation
 - constructor with parameters
 - auxiliary constructors
 - named parameters and default values
 - private fields, getters, setters vs. val/var someSetter_=
 - check constraints in constructor
 
 - inheritance
 - overriding a method
 - abstract
 - final
 
 - visibility (private[this])
 
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
 
 
### Notes

#### Exceptions in worksheet
Worksheet evaluation stops at the point where an exception is raised -> be careful with examples
 
#### Interactive mode
Disable interactive mode in worksheets to prevent jumping of the editor viewport

#### Overriding stuff
Concrete not optional
Abstract optional

methods
fields

from classes 
from traits

in classes
in traits


#### Getter/Setter
 - when parameter is declared as a val, the compiler generates a private field corresponding to each parameter (a different internal name is used), along with a public reader method that has the same name as the parameter.
 - if a parameter has the var keyword, a public writer method is also generated with the parameter’s name as a prefix, followed by _= . 

#### Inheritance
abstract
abstract vs. trait
final
Two  or  more methods  can  have  the  same  name  as  long  as  their  full  signatures  are  unique

Scala  supports  single  inheritance,  not  multiple  inheritance.  A  child  (or  derived)  class can  have  one  and  only  one  parent  (or  base)  class.  The  sole  exception  is  the  root  of  the Scala class hierarchy,  Any, which has no parent.

#### Auxiliary Constructors
 - avoid infinite recursion
 - invoke another constructor defined before it
 - must be the first statement in the auxiliary constructor’s body
 - super cannot be used to invoke a super class constructor.
 
#### Visibility
Scala visibility default is Public
Protected means only visible in same type and subtypes not in the package

.  Note,  however,  that  the  equalFields  method  can access private members of the  other  instance. The  declarations  of  PrivateClass5  and  PrivateClass6


#### Type Erasure
type  erasure
Suppose  two  methods  are  identical  except  that  one  takes  a  parameter  of type  List[String]  while the other takes a parameter of type  List[Int], as follows: // code-examples/BasicOOP/type-erasure-wont-compile.scala // WON'T COMPILE object Foo { def bar(list: List[String]) = list.toString def  bar(list:  List[Int]) = list.size.toString } You’ll  get  a  compilation  error  on  the  second  method  because  the  two  methods  will have an identical signature after type erasure.