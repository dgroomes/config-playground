# typesafe-config

Examples using the pure-Java configuration library [*Typesafe Config*](https://github.com/lightbend/config).


## Overview

*Typesafe Config* is a special library because it is featureful without dependencies. This is an exciting proposition.  


## Instructions

Follow these instructions to build and run the program.

1. Use Java 24
2. Run the program:
   - ```shell
     ./gradlew run
     ```
3. You should see something like this:
    ![output.png](output.png)
4. Alternatively, run the program and override one of the values using an environment variable:
   - ```shell
     CONFIG_FORCE_repeating__message="Hi from an environment variable!" ./gradlew run
     ```
5. Run the tests:
   - ```shell
     ./gradlew test
     ```


Here are some more variations of invoking the program:
- ```shell
  PAUSE="5 seconds" ./gradlew run
  ```
- ```shell
  pause1="10 seconds" ./gradlew run
  ```


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

- [x] DONE Overwrite the config with an environment variable
- [x] DONE Add tests
- [x] DONE Figure out why Typesafe Config is caching system properties between executions of the test methods. And fix the test.
- [x] DONE Create a highly circuitous configuration. It should have a default and be substitutable by an environment
  variable.


## Reference

- [Typesafe Config official example programs](https://github.com/lightbend/config/tree/main/examples/java)
  - The official repos has terrific examples apps that show simple and advanced ways to use the library.
- [Typesafe Config: *HOCON.md*](https://github.com/lightbend/config/blob/main/HOCON.md)
  - The official repo includes a great description of the HOCON file format (i.e.`.conf` files) 
