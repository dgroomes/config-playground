# yaml

Example Java program that uses a YAML file for config.

## Why?

YAML is today's 800-pound gorilla of config, especially in the "cloud native" space. Understanding YAML pays off.

## Instructions

Follow these instructions to build and run the program:

1. Build and run:
   * `./gradlew run`
   * You should see the program output the results of serializing and deserializing to and from YAML.

## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* Instead of using the `Fruit` enum as the type to (de)serialize to, use an object that represents something that looks
  like application configuration. This would be more inline with the spirit of this repo.
