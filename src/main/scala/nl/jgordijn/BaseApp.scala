package nl.jgordijn

import akka.actor.{ ActorRef, ActorSystem }
import scala.collection.breakOut
import scala.io.StdIn

abstract class BaseApp {
  val Opt = """(\S+)=(\S+)""".r

  def main(args: Array[String]): Unit = {
    val opts = argsToOpts(args.toList)
    applySystemProperties(opts)
    val system = ActorSystem("ping-pong")

    initialize(system)
    StdIn.readLine()
    system.shutdown()
  }
  def argsToOpts(args: Seq[String]): Map[String, String] =
    args.collect { case Opt(key, value) => key -> value }(breakOut)

  def applySystemProperties(options: Map[String, String]): Unit =
    for ((key, value) <- options if key startsWith "-D")
      System.setProperty(key substring 2, value)

  def initialize(system: ActorSystem): Unit
}
