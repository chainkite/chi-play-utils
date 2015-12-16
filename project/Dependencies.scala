import sbt._
import Keys._

object Dependencies {

  object V {
    final lazy val slf4j = "1.7.12"
    final lazy val typesafeConfig = "1.2.1"
    final lazy val scalatest = "2.2.4"
    final lazy val mavenArtifact = "3.3.3"

    object play {
      final lazy val play = "2.4.5"
      final lazy val scalatest = "1.4.0-M4"
      final lazy val scaldi = "0.5.9"
      final lazy val bootstrap = "0.4.5-P24"
    }
    final lazy val chkCommons = "0.1.0"
  }

  lazy val chkCommonsCore = "chainkite" %% "chk-commons-core" % V.chkCommons
  lazy val chkCommonsTest = "chainkite" %% "chk-commons-test" % V.chkCommons

  lazy val slf4j = "org.slf4j" % "slf4j-api" % V.slf4j
  lazy val typesafeConfig = "com.typesafe" % "config" % V.typesafeConfig
  lazy val scalatest = "org.scalatest" %% "scalatest" % V.scalatest
  lazy val mavenArtifact = "org.apache.maven" % "maven-artifact" % V.mavenArtifact

  object play {
    lazy val core = "com.typesafe.play" %% "play" % V.play.play
    lazy val scaldi = "org.scaldi" %% "scaldi-play" % V.play.scaldi
    lazy val bootstrap = "com.adrianhurt" %% "play-bootstrap3" % V.play.bootstrap

    lazy val test = "com.typesafe.play" %% "play-test" % V.play.play
    lazy val scalatest = "org.scalatestplus" %% "play" % V.play.scalatest
  }

}
