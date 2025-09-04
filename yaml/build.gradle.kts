val slf4jVersion = "2.0.17" // SLF4J releases: http://www.slf4j.org/news.html
val snakeYamlVersion = "2.4" // SnakeYAML releases: https://bitbucket.org/snakeyaml/snakeyaml/wiki/Installation

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.yaml:snakeyaml:$snakeYamlVersion")
}


application {
    mainClass.set("dgroomes.Main")
}
