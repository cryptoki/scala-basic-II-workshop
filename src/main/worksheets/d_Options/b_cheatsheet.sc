val option : Option[Int] = Some(1)
val optionOption: Option[Option[Int]] = Some(Some(1))
def func(x: Int) = Some(x+1)
def func2(x: Int) = x*3

/* flatMap */
val flatMap1 = option match {
  case None => None
  case Some(x) => func(x)
}
val flatMap2 = option flatMap func

/* flatten */
val flatten1 = optionOption match {
  case None => None
  case Some(x) => x
}
val flatten2 = optionOption flatten

/* map */
val option1 = option match {
  case None => None
  case Some(x) => Some(func2(x))
}
val option2 = option map func2

/* foreach */
option match {
  case None => {}
  case Some(x) => func(x)
}
option foreach func

/* isDefined */
val isDefined1 = option match {
  case None => false
  case Some(_) => true
}
val isDefined2 = option isDefined
/*
isDefined

option match {
  case None => false
  case Some(_) => true
}
This code is equivalent to:

  option.isDefined
isEmpty

option match {
  case None => true
  case Some(_) => false
}
This code is equivalent to:

  option.isEmpty
forall

option match {
  case None => true
  case Some(x) => foo(x)
}
This code is equivalent to:

  option.forall(foo(_))
exists

option match {
  case None => false
  case Some(x) => foo(x)
}
This code is equivalent to:

  option.exists(foo(_))
orElse

option match {
  case None => foo
  case Some(x) => Some(x)
}
This code is equivalent to:

  option.orElse(foo)
getOrElse

option match {
  case None => foo
  case Some(x) => x
}
This code is equivalent to:

  option.getOrElse(foo)
toList

option match {
  case None => Nil
  case Some(x) => x :: Nil
}
This code is equivalent to:

  option.toList
coflatMap1

option match {
  case None => None
  case Some(_) => Some(foo(option))
}
This code is equivalent to:

  option.coflatMap(foo(_))
duplicate2

option match {
  case None => None
  case Some(_) => Some(option)
}
This code is equivalent to:

  option.duplicate
*/