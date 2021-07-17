package dgroomes;

import org.yaml.snakeyaml.Yaml;

import java.util.List;

/**
 * A serializer and deserializer (often referred to as a "serde") for serializing a list of Java values into a YAML
 * document and by converse, deserializing a YAML document into a list of Java values.
 * <p>
 * This is a toy class that exists to illustrate SnakeYAML.
 */
public class YamlSerde {

    private final Yaml yaml;

    public YamlSerde() {
        yaml = new Yaml();
    }

    /**
     * Serialize a list of values into a YAML document
     *
     * @param values list of values to serialize
     * @return a string value of the given values serialized into a YAML document
     */
    public String serialize(List<Object> values) {
        return yaml.dump(values);
    }

    /**
     * Deserialize a YAML list document into a list of Java values.
     *
     * @param yaml the YAMl document to deserialize
     * @return the deserialized list of Java values
     */
    public List<Object> deserialize(String yaml) {
        return this.yaml.load(yaml);
    }
}
