package nl.jgordijn

import akka.actor.ActorSystem
import akka.routing.FromConfig

object PingApp extends App {
  val system = ActorSystem("ping-pong")
  val pongActor = system.actorOf(FromConfig().props(PongActor.props), "pong")
  val pingActor = system.actorOf(PingActor.props(pongActor), "ping")
  system.awaitTermination()
}
