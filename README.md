# config-playground

📚 Learning and exploring various configuration technologies in the JVM space.


## Overview

The range of software configuration tools, languages and idioms are infinite. At times, configuration work feels like
it is about 50% of software engineering! Given how large the space is and how much time we spend doing it, I want to
chisel away at the mountain of configuration options and learn them in-depth.


## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:


### `typesafe-config/`

Examples using the pure-Java configuration library [*Typesafe Config*](https://github.com/lightbend/config).

See the README in [typesafe-config/](typesafe-config/).


### `yaml/`

Example Java program that uses a YAML (YAML Ain't Markup Language) file for config.

See the README in [yaml/](yaml/).


### `toml/`

Example Java program that uses a TOML (Tom's Obvious Minimal Language) file for config.

See the README in [toml/](toml/).


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Add a YAML sub-project
* [ ] SKIP (I haven't heard much of CUE in recent years) Potentially add a [CUE](https://github.com/cuelang/cue) sub-project
* [x] DONE Add a TOML sub-project


## Reference

* [Spring configuration example project: `dgroomes/spring-playground`](https://github.com/dgroomes/spring-playground)
  * In the linked repo, there is a sub-project called "config/" which showcases some configuration features of Spring Framework
    and Spring Boot. Spring is a great example of software with a sophisticated configuration sub-system. It's one of, if
    not my favorite, features of Spring. It's not always easy, but it's extremely featureful.
