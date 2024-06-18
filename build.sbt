ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "Scala-TST"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)