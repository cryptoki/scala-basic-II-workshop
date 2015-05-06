name := "scala-basics-part-2"

version := "0.1.0-SNAPSHOT"

organization := "de.epost"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-Xmax-classfile-name", "128", "-deprecation","-unchecked")

// See more at: http://typesafe.com/blog/improved-dependency-management-with-sbt-0137#sthash.NdNCcL2I.dpuf
updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.5",
  "org.joda" % "joda-convert" % "1.7",
  "org.scala-lang.modules" %% "scala-async" % "0.9.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.7"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.2",
  "org.mockito" % "mockito-core" % "1.10.8"
).map(_ % "test")

lazy val root =
  project.in( file(".") )
