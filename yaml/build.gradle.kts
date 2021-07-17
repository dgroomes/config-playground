val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val snakeYamlVersion = "1.25" // releases: https://bitbucket.org/asomov/snakeyaml/wiki/Installation

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
    implementation("org.yaml:snakeyaml:$snakeYamlVersion")
}


application {
    mainClass.set("dgroomes.Main")
}
