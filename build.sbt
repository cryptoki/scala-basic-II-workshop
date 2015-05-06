name := "scala-basics-part-2"

version := "0.1.0-SNAPSHOT"

organization := "de.epost"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-Xmax-classfile-name", "128", "-deprecation","-unchecked")

// See more at: http://typesafe.com/blog/improved-dependency-management-with-sbt-0137#sthash.NdNCcL2I.dpuf
//updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.7"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4"
).map(_ % "test")

lazy val root =
  project.in( file(".") )
