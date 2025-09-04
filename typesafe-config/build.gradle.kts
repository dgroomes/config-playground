val slf4jVersion = "2.0.17" // SLF4J releases: http://www.slf4j.org/news.html
val junitVersion = "5.13.4" // JUnit releases: https://junit.org/junit5/docs/current/release-notes/index.html
val typesafeConfigVersion = "1.4.4" // TypeSafe Comfig releases: https://github.com/lightbend/config/tags

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.typesafe:config:$typesafeConfigVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

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
