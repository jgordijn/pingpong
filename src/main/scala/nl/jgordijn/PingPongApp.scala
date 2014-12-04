package nl.jgordijn

import akka.actor._
import akka.routing.FromConfig
import akka.contrib.pattern._

object PingPongApp extends BaseApp {
  override def initialize(system: ActorSystem): Unit = {
    val pongRouter = system.actorOf(FromConfig().props(), "pongRouter")
    val ponger = system.actorOf(PongActor.props, "pong")

    system.actorOf(ClusterSingletonManager.props(
      singletonProps = PingActor.props(pongRouter),
      singletonName = "Pinger",
      terminationMessage = PoisonPill,
      role = None),
      name = "singleton")
  }
}
