package nl.jgordijn

import akka.actor._
import scala.concurrent.duration._

case object Ping
case object Pong

object PingActor {
  def props(pongActor: ActorRef): Props = Props(new PingActor(pongActor))
}
class PingActor(pong: ActorRef) extends Actor with ActorLogging {
  import context.dispatcher
  var counter = 0
  val reschedule = 1.second
  context.setReceiveTimeout(2 seconds)

  override def preStart() = {
    context.system.scheduler.scheduleOnce(reschedule, pong, Ping)
  }

  override def receive: Receive = {
    case Pong =>
      counter += 1
      log.info("I received Pong {} times", counter)
      context.system.scheduler.scheduleOnce(reschedule, pong, Ping)
    case ReceiveTimeout =>
      log.info("TIMEOUT. I received Pong {} times", counter)
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
