Common.settings
 
libraryDependencies ++= Dependencies.pingPong
 
initialCommands := """|import nl.jgordijn._
                      |import akka.actor._
                      |import scala.concurrent._
                      |import scala.concurrent.duration._""".stripMargin
