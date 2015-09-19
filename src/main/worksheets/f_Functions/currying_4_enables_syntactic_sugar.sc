//Second, and more importantly, type inference can usually figure out the function's
// parameter type, so it does not have to be given at the call site. For instance, if
// I define a max function over lists like this:
def maxCurried[T](xs: List[T])(compare: (T, T) => Boolean)
//I can call it like this:

maxCurried(List(1, -3, 43, 0))((x, y) => x < y)
//or even shorter:

maxCurried(List(1, -3, 43, 0))(_ < _)
//If I defined max as an uncurried function, this would not work, I'd have to call it like this:

def max[T](xs: List[T], compare: (T, T) => Boolean)
max(List(1, -3, 43, 0), (x: Int, y: Int) => x < y)