val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val tomlJVersion = "1.0.0" // TomlJ releases: https://github.com/tomlj/tomlj/releases

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.tomlj:tomlj:$tomlJVersion")
}

application {
    mainClass.set("dgroomes.Main")
}
