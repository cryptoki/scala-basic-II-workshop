val options = List(Some(2), None, Some(4), Some(6), None)
val options2 = Some(2) ++ None ++ Some(4) ++ Some(6) ++ None
val options3 = Some("4rf") ++: Some("34345") ++: "sdfd"

val option = Some(3)
option.exists(_ == 3)
option.exists _ == 3