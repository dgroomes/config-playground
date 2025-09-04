val slf4jVersion = "2.0.17" // SLF4J releases: http://www.slf4j.org/news.html
val jacksonBomVersion = "2.20.0" // Jackson releases: https://github.com/FasterXML/jackson/wiki/Jackson-Releases

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonBomVersion"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
}

application {
    mainClass.set("dgroomes.Main")
}
