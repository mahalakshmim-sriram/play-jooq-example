import com.github.kxbmap.sbt.jooq.CodegenStrategy.Always

name := "play-java-jooq"


version := "1.0-SNAPSHOT"

lazy val `play-java-jooq` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

PlayKeys.playDefaultPort := 9440

// Enable the plugin
enablePlugins(JooqCodegen)

libraryDependencies += guice

libraryDependencies += javaJdbc

libraryDependencies ++= Seq(
  ws,
  javaCore,
  "ch.qos.logback" % "logback-classic" % "1.0.11",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.8.1",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % "2.2.3",
  "com.itextpdf" % "itextpdf" % "5.5.9",
  "commons-beanutils" % "commons-beanutils" % "1.9.3",
  "commons-collections" % "commons-collections" % "3.2.1",
  "org.aspectj" % "aspectjweaver" % "1.9.4",
  "org.json" % "json" % "20180813",
  "org.flywaydb" %% "flyway-play" % "5.3.2",
  "org.apache.commons" % "commons-io" % "1.3.2",
  "org.postgresql" % "postgresql" % "42.2.6",
  "org.postgresql" % "postgresql" % "42.2.6" % "jooq",
  "org.jooq" % "jooq" % "3.11.5",
  "org.projectlombok" % "lombok" % "1.16.16",
  "org.modelmapper" % "modelmapper" % "0.7.6",
  "org.apache.commons" % "commons-csv" % "1.4",
  "com.opencsv" % "opencsv" % "4.5",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

javacOptions ++= Seq(
  "-Xlint:unchecked",
  "-Xlint:deprecation"
)


jooqVersion := "3.11.5"
jooqOrganization := "org.jooq"
autoJooqLibrary := true
// Set file path
jooqCodegenConfig := baseDirectory.value/"conf/jooq-config.xml"
jooqCodegenStrategy := Always