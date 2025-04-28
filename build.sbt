name := "ScalaSparkDemo"
version := "0.1.0"
scalaVersion := "2.12.18"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.2",
  "org.apache.spark" %% "spark-sql" % "3.3.2"
)

Compile / mainClass := Some("ReadAAPLCSV")
