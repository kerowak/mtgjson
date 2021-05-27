val AkkaVersion = "2.6.14"
val CirceVersion = "0.13.0"

val client = project
  .settings(
    version := "0.2.1",
    name := "mtgjson",
    organization := "com.kerowak",
    scalaVersion := "2.13.4"
  ).settings(
    libraryDependencies ++= Seq(
        "com.softwaremill.sttp.client3" %% "core" % "3.2.0",
        "com.softwaremill.sttp.client3" %% "circe" % "3.2.0",

        "com.lightbend.akka" %% "akka-stream-alpakka-json-streaming" % "2.0.2",
        "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
        "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
        "com.typesafe.akka" %% "akka-http" % "10.2.4",

        "io.circe" %% "circe-core" % CirceVersion,
        "io.circe" %% "circe-generic" % CirceVersion,
        "io.circe" %% "circe-generic-extras" % CirceVersion,
        "io.circe" %% "circe-parser" % CirceVersion,

        "com.beachape" %% "enumeratum" % "1.6.0",
        "com.beachape" %% "enumeratum-circe" % "1.6.0",
    )
  )
