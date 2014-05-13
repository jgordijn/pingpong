import sbt._

object Version {
  val akka         = "2.3.2"
  val logback      = "1.1.2"
  val scala        = "2.11.0"
}

object Library {
  val akkaActor      = "com.typesafe.akka"      %% "akka-actor"               % Version.akka
  val akkaCluster    = "com.typesafe.akka"      %% "akka-cluster"             % Version.akka
  val akkaSlf4j      = "com.typesafe.akka"      %% "akka-slf4j"               % Version.akka
  val logbackClassic = "ch.qos.logback"         %  "logback-classic"          % Version.logback
}

object Dependencies {

  import Library._

  val pingPong = List(
    akkaActor,
    akkaCluster,
    akkaSlf4j,
    logbackClassic
  )
}

