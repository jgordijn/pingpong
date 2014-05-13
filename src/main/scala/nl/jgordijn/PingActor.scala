package nl.jgordijn

import akka.actor.{Props, ActorRef, ActorLogging, Actor}
import scala.concurrent.duration._

case object Ping
case object Pong

object PingActor {
  def props(pongActor: ActorRef): Props = Props(new PingActor(pongActor))
}
class PingActor(pong: ActorRef) extends Actor with ActorLogging {
  import context.dispatcher
  var counter = 0
  val reschedule = 1 second

  override def preStart() = context.system.scheduler.scheduleOnce(reschedule, pong, Ping)

  override def receive: Receive = {
    case Pong =>
      counter += 1
      log.info("I received Pong {} times", counter)
      context.system.scheduler.scheduleOnce(reschedule, pong, Ping)
  }
}

object PongActor {
  def props: Props = Props(new PongActor)
}
class PongActor extends Actor with ActorLogging {
  var counter = 0

  override def receive: Receive = {
    case Ping =>
      counter += 1
      log.info("I received Ping {} times", counter)
      sender() ! Pong
  }
}
