val slf4jVersion = "2.0.17" // SLF4J releases: http://www.slf4j.org/news.html
val hopliteVersion = "2.9.0" // Hoplite releases: https://github.com/sksamuel/hoplite/releases

plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sksamuel.hoplite:hoplite-core:$hopliteVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
}

application {
    mainClass.set("dgroomes.Main")
}
