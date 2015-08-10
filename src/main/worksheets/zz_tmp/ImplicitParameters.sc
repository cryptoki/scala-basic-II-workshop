import java.util.UUID

case class Transaction(id: String = UUID.randomUUID().toString) {
  def commit() = println(s"commit $id")
  def rollback() = println(s"rollback $id")
}

def isAuthorized(bankAccount: String)(implicit transaction:Transaction) = {
  true
}
def withdraw(bankAccount: String, sum: Double) (implicit transaction: Transaction): Unit = {
  require(Math.abs(sum) <= 100, "can only withdraw sums up to 100€")
  println(s"transaction $transaction withdraw sum from $bankAccount")
}

def withTransaction(block: Transaction => Unit) : Unit = {
  val transaction = new Transaction()
  try {
    block(transaction)
    transaction.commit()
  } catch {
    case t: Throwable =>
      println(s"error with transaction $transaction")
  }
}

def transfer(fromBankAccount: String, toBankAccount: String, sum: Double): Unit = {
  withTransaction {
    implicit transaction: Transaction =>
      withdraw(fromBankAccount, -sum) (transaction)
      // kann weg gelassen werden, da es implicit im Scope vorliegt
      withdraw(toBankAccount, sum)
  }
}

transfer("bob", "alice", 20.0)