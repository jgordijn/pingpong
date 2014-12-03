Common.settings
 
libraryDependencies ++= Dependencies.pingPong
 
initialCommands := """|import nl.jgordijn._
                      |import akka.actor._
                      |import scala.concurrent._
                      |import scala.concurrent.duration._""".stripMargin

addCommandAlias("pp1", "runMain nl.jgordijn.PingPongApp -Dakka.remote.netty.tcp.port=2551 -Dakka.cluster.roles.0=ping-node")

addCommandAlias("pp2", "runMain nl.jgordijn.PingPongApp -Dakka.remote.netty.tcp.port=2552 -Dakka.cluster.roles.0=ping-node")

addCommandAlias("pp3", "runMain nl.jgordijn.PingPongApp -Dakka.remote.netty.tcp.port=0 -Dakka.cluster.roles.0=pong-node")
