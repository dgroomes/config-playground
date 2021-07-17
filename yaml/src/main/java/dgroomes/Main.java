package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var yamlSerde = new YamlSerde();
        List<Object> values = List.of("Hello", 123, true);

        // Serialize
        var serializedYaml = yamlSerde.serialize(values);
        log.info("Serialized a list of Java values into the following YAML list document:\n{}", serializedYaml);

        // Deserialize
        var deserializedObjects = yamlSerde.deserialize(serializedYaml);
        log.info("Deserialized a YAML list document into a list of Java values: {}", deserializedObjects);
    }
}
