val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val tomlJVersion = "1.0.0" // releases: https://github.com/tomlj/tomlj/releases

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
