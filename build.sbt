Common.settings
 
libraryDependencies ++= Dependencies.pingPong
 
initialCommands := """|import nl.jgordijn._
                      |import akka.actor._
                      |import scala.concurrent._
                      |import scala.concurrent.duration._""".stripMargin

addCommandAlias("pingApp", "runMain nl.jgordijn.PingApp -Dakka.remote.netty.tcp.port=2551 -Dakka.cluster.roles.0=ping-node")

addCommandAlias("pongApp", "runMain nl.jgordijn.PongApp -Dakka.remote.netty.tcp.port=0 -Dakka.cluster.roles.0=pong-node")

