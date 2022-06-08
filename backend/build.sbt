import Dependencies._

ThisBuild / name := "Shop"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"

enablePlugins(DockerPlugin)

libraryDependencies ++= backendDeps
