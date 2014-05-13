package nl.jgordijn

import akka.actor.ActorSystem

object PongApp extends BaseApp {
  override def initialize(system: ActorSystem): Unit = {
    val pongActor = system.actorOf(PongActor.props, "pong")
  }
}
