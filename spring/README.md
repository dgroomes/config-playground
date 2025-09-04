# spring

Example of Spring's *core* property system.


## Overview

We rarely use Spring without Spring Boot, but Spring is modularized quite well, and the `spring-core` module is very useful on its own. This project shows how to use Spring's property system, which is part of `spring-core`.


## Instructions

Follow these instructions to build and run the program.

1. Use Java 24
2. Build and run:
   - ```shell
     ./gradlew run
     ```
   - You should see the output of a simple program that is configured with values read from the `application.properties` file in the classpath resources.
3. Alternatively, run the program and override one of the values using an environment variable:
   - ```shell
     repeatingMessage="Hi from an environment variable!" ./gradlew run
     ```
4. Run the tests:
   - ```shell
     ./gradlew test
     ```
5. Try some more variations of invoking the program:
   - ```shell
     pause=3000 ./gradlew run
     ```
   - ```shell
     repetitions=5 ./gradlew run
     ```


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

- [x] DONE First cut.
- [ ] Get rid of Settings. Unnecessary abstraction for a demo.
