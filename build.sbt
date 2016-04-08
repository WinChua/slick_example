lazy val hello = taskKey[Unit]("An example")

//val pi = project.in _

val derby = "org.apache.derby" % "derby" % "10.4.1.3"



lazy val root = (project in file(".")).settings(
	//name in Compile := "hello",
	name := "hello",
	version := "1.0",
	scalaVersion := "2.11.7"
).settings(
    hello := {println("Hello")},
    libraryDependencies += derby
).settings(
    libraryDependencies ++= Seq(
	  "com.typesafe.slick" %% "slick" % "3.1.1",
	  "org.slf4j" % "slf4j-nop" % "1.6.4",
	  "mysql" % "mysql-connector-java" % "5.1.18",
	  "com.typesafe.slick" %% "slick-codegen" % "3.1.1"
	)
)