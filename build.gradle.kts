plugins {
  id("java")
  id("net.kyori.blossom") version "2.1.0"
}

group = "es.angelillo15"
version = "1.0.0"

repositories {
  mavenCentral()
  maven("https://repo.nookure.com/releases")
}

dependencies {
  compileOnly("com.nookure.mast:MAStaff-API:3.0.3-BETA")
}

sourceSets {
  main {
    blossom {
      javaSources {
        property("version", project.version.toString())
      }
    }
  }
}