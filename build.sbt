val scala3Version = "3.8.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "cash",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      // ScalaTest
      "org.scalatest" %% "scalatest" % "3.2.17" % Test,

      // ScalaCheck
      "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
      
    )
  )
