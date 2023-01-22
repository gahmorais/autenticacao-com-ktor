val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val ktorm_version: String by project
val postgres_driver_version: String by project

plugins {
  kotlin("jvm") version "1.8.0"
  id("io.ktor.plugin") version "2.2.2"
}

group = "br.com.gabriemorais"
version = "0.0.1"
application {
  mainClass.set("io.ktor.server.netty.EngineMain")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")

//  val isDevelopment: Boolean = project.ext.has("development")
//  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${true}")
}

repositories {
  mavenCentral()
}

dependencies {
  //Log Depencies
  implementation("ch.qos.logback:logback-classic:$logback_version")

  //Ktor Dependencies
  implementation("io.ktor:ktor-server-core:$ktor_version")
  implementation("io.ktor:ktor-server-swagger:$ktor_version")
  implementation("io.ktor:ktor-server-netty:$ktor_version")
  implementation("io.ktor:ktor-server-config-yaml:$ktor_version")

  implementation("io.ktor:ktor-server-auth:$ktor_version")

  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-gson:$ktor_version")

  //Tests Dependencies
  testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}