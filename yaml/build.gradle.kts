val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val snakeYamlVersion = "1.30" // SnakeYAML releases: https://bitbucket.org/snakeyaml/snakeyaml/wiki/Installation

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
