package nl.jgordijn

import akka.actor.ActorSystem

object PingApp extends App {
  val system = ActorSystem("ping-pong")
  val pongActor = system.actorOf(PongActor.props, "ping")
  val pingActor = system.actorOf(PingActor.props(pongActor), "pong")
  system.awaitTermination()
}
