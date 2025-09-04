val slf4jVersion = "2.0.17" // SLF4J releases: http://www.slf4j.org/news.html
val junitVersion = "5.13.4" // JUnit releases: https://junit.org/junit5/docs/current/release-notes/index.html
val springVersion = "6.2.10" // Spring Framework releases: https://github.com/spring-projects/spring-framework/releases

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.springframework:spring-core:$springVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.springframework:spring-test:$springVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    withType(Test::class.java) {
        useJUnitPlatform()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}

application {
    mainClass.set("dgroomes.Main")
}
