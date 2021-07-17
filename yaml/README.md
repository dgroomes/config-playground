# yaml

Example Java program that uses a YAML (YAML Ain't Markup Language) file for config.

## Why?

YAML is today's 800-pound gorilla of config, especially in the "cloud native" space. Understanding YAML pays off. This
project specifically uses YAML in a Java context but of course YAML is used heavily in other contexts, like Go programs,
infrastructure tooling, etc.

## Instructions

Follow these instructions to build and run the program:

1. Use Java 11
1. Build and run:
   * `./gradlew run`
   * You should see the output of a simple program that is configured with values read from the `config.yml` file in the
     classpath resources.

## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Instead of using the `Fruit` enum as the type to (de)serialize to, use an object that represents something that looks
  like application configuration. This would be more inline with the spirit of this repo.
* DONE (Answer: yes. Use SnakeYAML straight up instead of Jackson) Can the objectMapper be configured to not include the document delimiter (`---`)?

## Reference

* [*SnakeYAML* git repo on BitBucket](https://bitbucket.org/asomov/snakeyaml/wiki/Documentation)
  * Thank you SnakeYAML project, for implementing a YAML parser/generator in Java!
* [Official YAML site](https://yaml.org/)
