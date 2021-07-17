val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val jacksonBomVersion = "2.12.3" // releases: https://github.com/FasterXML/jackson/wiki/Jackson-Releases

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
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
}


application {
    mainClass.set("dgroomes.Main")
}
