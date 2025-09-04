# toml

Example Java program that uses a TOML (Tom's Obvious Minimal Language) file for config.


## Instructions

Follow these instructions to build and run the program.

1. Use Java 24
2. Build and run:
   - ```shell
     ./gradlew run
     ```
   - You should see the output of a simple program that is configured with values read from the `config.toml` file in
      the classpath resources.


## Notes

How do you choose a TOML Java library? There are a few options like [TomlJ](https://github.com/tomlj/tomlj) and [Jackson's
support for TOML in its `jackson-dataformats-text` library](https://github.com/FasterXML/jackson-dataformats-text/tree/2.14/toml).
The [TOML website has a convenient list of TOML implementations](https://github.com/toml-lang/toml/wiki) across programming
languages. I recommend it.

TomlJ requires transitive runtime dependencies on ANTLR and FindBugs. I think Jackson has implemented its TOML support
without additional dependencies and the implementation is quite recent (2021). Virtually all of my Java projects that use
JSON are already invested in Jackson. I would prefer Jackson over TomlJ for TOML.


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Switch over to Jackson and away from TomlJ. 


## Reference

- [*TomlJ* GitHub repo](https://github.com/tomlj/tomlj)
    - A TOML parser implemented in Java
- [The TOML website](https://toml.io/en/)
