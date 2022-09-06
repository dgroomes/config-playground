val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val jacksonBomVersion = "2.13.4" // Jackson releases: https://github.com/FasterXML/jackson/wiki/Jackson-Releases

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
    implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonBomVersion"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")
}

application {
    mainClass.set("dgroomes.Main")
}
