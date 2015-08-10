import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorSystem}

val system = ActorSystem.create()
class EchoServer extends Actor {
  override def receive: Receive = ???
}