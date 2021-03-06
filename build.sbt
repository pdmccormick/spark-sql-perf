// Your sbt build file. Guides on how to write one can be found at
// http://www.scala-sbt.org/0.13/docs/index.html

name := "spark-sql-perf"

organization := "com.databricks"

scalaVersion := "2.10.4"

// All Spark Packages need a license
licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

initialCommands in console :=
  """
    |import org.apache.spark.sql._
    |import org.apache.spark.sql.functions._
    |import org.apache.spark.sql.types._
    |import org.apache.spark.sql.hive.test.TestHive
    |import TestHive.implicits
    |import TestHive.sql
    |
    |val sqlContext = TestHive
    |import sqlContext.implicits._
  """.stripMargin

// TODO: remove after Spark 2.0.0 is released:
//resolvers += "apache-snapshots" at "https://repository.apache.org/snapshots/"
resolvers += Resolver.sonatypeRepo("public")

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.5"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.3.0"

libraryDependencies += "com.twitter" %% "util-jvm" % "6.23.0" % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.0" % "provided"

fork := true

test in assembly := {}

/********************
 * Release settings *
 ********************/

publishMavenStyle := true

releaseCrossBuild := true

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

pomExtra := (
      <url>https://github.com/databricks/spark-sql-perf</url>
      <scm>
        <url>git@github.com:databricks/spark-sql-perf.git</url>
        <connection>scm:git:git@github.com:databricks/spark-sql-perf.git</connection>
      </scm>
      <developers>
        <developer>
          <id>marmbrus</id>
          <name>Michael Armbrust</name>
          <url>https://github.com/marmbrus</url>
        </developer>
        <developer>
          <id>yhuai</id>
          <name>Yin Huai</name>
          <url>https://github.com/yhuai</url>
        </developer>
        <developer>
          <id>nongli</id>
          <name>Nong Li</name>
          <url>https://github.com/nongli</url>
        </developer>
        <developer>
          <id>andrewor14</id>
          <name>Andrew Or</name>
          <url>https://github.com/andrewor14</url>
        </developer>
        <developer>
          <id>davies</id>
          <name>Davies Liu</name>
          <url>https://github.com/davies</url>
        </developer>
      </developers>
    )

bintrayReleaseOnPublish in ThisBuild := false
