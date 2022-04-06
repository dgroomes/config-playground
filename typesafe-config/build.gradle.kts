val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val junitJupiterVersion = "5.8.2" // JUnit releases: https://junit.org/junit5/docs/current/release-notes/index.html
val typesafeConfigVersion = "1.4.2" // TypeSafe Comfig releases: https://github.com/lightbend/config/tags

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
    implementation("com.typesafe:config:$typesafeConfigVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
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
