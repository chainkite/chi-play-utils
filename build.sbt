import Dependencies._
import ShellPromptPlugin._


lazy val VERSION = "0.1.0-SHAPSHOT"

lazy val jvmSource = "1.8"
lazy val jvmTarget = "1.8"


lazy val depOverrides = Set(
  slf4j,
  typesafeConfig,
  scalatest
)

lazy val buildSettings = Seq(
  organization := "com.chn",
  version in ThisBuild := VERSION,
  scalaVersion := "2.11.7",
  shellPrompt := buildShellPrompt(version.value),
  unmanagedJars in Compile <<= baseDirectory.map(base => (base / "lib" ** "*.jar").classpath),
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:higherKinds", "-language:postfixOps",
    "-language:implicitConversions", "-language:reflectiveCalls", "-language:existentials", s"-target:jvm-$jvmTarget",
    "-encoding", "utf8"),
  javacOptions in Compile ++= Seq("-target", jvmTarget, "-source", jvmSource, "-Xlint:deprecation"),
  resolvers ++= Seq(
    "Chainkite Repository" at "http://dl.bintray.com/chainkite/maven",
    "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
  ),
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  bintrayReleaseOnPublish in ThisBuild := false
)

lazy val `chk-play-utils` = (project in file(".")).
  settings(buildSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      chkCommonsCore, 
      play.core,
      play.scaldi, 
      play.bootstrap,
      mavenArtifact % Provided.intransitive,
      chkCommonsTest % Test,
      play.test % Test,
      play.scalatest % Test
    ),
    dependencyOverrides ++= depOverrides
  )