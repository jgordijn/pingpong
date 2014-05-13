This is an Akka ping pong game with clustering

The app consists of two applications: One Ping app and one Pong app.
The Ping app is started once via: 'sbt pingApp'

The pong app can be started multiple times via: 'sbt pongApp'

 The pingApp is the seed node and the node that will send out Ping messages. A Pong app will join the cluster and start responding to Pings.

  Watch the logs to see what happens when you start multiple pong apps.

  BTW every commit is a working app so you can see how to go from a local app to a cluster app.