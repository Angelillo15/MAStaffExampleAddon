plugins {
  id("java")
}

group = "es.angelillo15"
version = "1.0"

repositories {
  mavenCentral()
  maven("https://repo.nookure.com/releases")
}

dependencies {
  compileOnly("com.nookure.mast:MAStaff-API:3.0.3-BETA")
}
