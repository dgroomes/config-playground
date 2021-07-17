package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var yamlSerde = new YamlSerde();
        var fruit = List.of(YamlSerde.Fruit.ORANGE, YamlSerde.Fruit.BANANA, YamlSerde.Fruit.APPLE);

        // Serialize
        var serializedYaml = yamlSerde.serialize(fruit);
        log.info("Serialized a list of fruit objects in the following YAML document:\n{}", serializedYaml);

        // Deserialize
        var deserializedObjects = yamlSerde.deserialize(serializedYaml);
        log.info("Deserialized a YAML document of fruits into a list of fruit objects: {}", deserializedObjects);
    }
}
