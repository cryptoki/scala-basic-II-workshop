

def sum(x: Int, y: Int) = x + y
def sumCurried(x: Int)(y: Int) = x + y


def acceptString(s: String, pred: String => Boolean): Boolean = pred(s)

acceptString("Hello World", seq => seq.length > 1)
acceptString("Hello World", seq => seq.length < 100)

def acceptStringCurried(s: String)(pred: String => Boolean): Boolean = pred(s)

acceptStringCurried("Hello World") {
  seq => seq.length > 1
}

acceptStringCurried("Hello World") {
  seq => seq.length < 100
}