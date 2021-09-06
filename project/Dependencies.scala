import sbt._
object Dependencies {
  lazy val sprayJsonVersion="1.3.6"
  lazy val sprayJson="io.spray" %% "spray-json" % sprayJsonVersion
  lazy val kafkaVersion= "2.8.0"
  lazy val kafka="org.apache.kafka" % "kafka-clients" % kafkaVersion
  lazy val slickVersion="3.3.3"
  lazy val slick= "com.typesafe.slick" %% "slick" % slickVersion
  lazy val mySqlVersion="8.0.26"
  lazy val mySqlConnector="mysql" % "mysql-connector-java" % mySqlVersion
  lazy val hickariCp="com.typesafe.slick" %% "slick-hikaricp" % slickVersion
  lazy val SLF4J="org.slf4j" % "slf4j-api" % "2.0.0-alpha4"

  def compileDependencies: Seq[ModuleID] =Seq(sprayJson,kafka,mySqlConnector,slick,hickariCp,SLF4J)

}
