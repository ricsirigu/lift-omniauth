import LiftModule.{liftVersion, liftEdition}

name := "Omniauth"

organization := "net.liftmodules"

homepage := Some(url("https://github.com/ghostm/lift-omniauth"))

version := "0.18"

liftVersion := "3.1.0"

liftEdition := liftVersion.value.substring(0,3)

name := name.value + "_" + liftEdition.value

moduleName := name.value.toLowerCase

scalaVersion := "2.11.11"

crossScalaVersions := Seq("2.11.11", "2.12.2")

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies++= Seq(
  "net.liftweb"   %% "lift-webkit"  % liftVersion.value  % "provided",
  "net.databinder" %% "dispatch-core" % "0.8.10",
  "net.databinder" %% "dispatch-http" % "0.8.10",
  "net.databinder" %% "dispatch-oauth" % "0.8.10",
  "net.databinder" %% "dispatch-http-json" % "0.8.10"
)


//scalacOptions ++= Seq("-feature")

publishTo := (version.value.endsWith("SNAPSHOT") match {
        case true  => Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
        case false => Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
  }
)

credentials += Credentials( file("sonatype.credentials") )

credentials += Credentials( file("/private/liftmodules/sonatype.credentials") )
 
publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
         <scm>
            <url>git@github.com:ghostm/lift-omniauth.git</url>
            <connection>scm:git:git@github.com:ghostm/lift-omniauth.git</connection>
         </scm>
         <developers>
            <developer>
              <id>ghostm</id>
              <name>Matthew Henderson</name>
              <url>https://github.com/ghostm</url>
            </developer>
         </developers>
 )

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

seq(lsSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq("lift", "oauth")

(description in LsKeys.lsync) := "Omniauth for Lift"

(LsKeys.ghUser in LsKeys.lsync) := Some("ghostm")

(LsKeys.ghRepo in LsKeys.lsync) := Some("lift-omniauth")

(LsKeys.ghBranch in LsKeys.lsync) := Some("master")
