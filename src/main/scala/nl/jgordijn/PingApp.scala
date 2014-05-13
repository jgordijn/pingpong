package nl.jgordijn

import akka.actor.ActorSystem
import akka.routing.FromConfig

object PingApp extends BaseApp {
  override def initialize(system: ActorSystem): Unit = {
    val pongActor = system.actorOf(FromConfig().props(), "pong")
    val pingActor = system.actorOf(PingActor.props(pongActor), "ping")
  }

}
