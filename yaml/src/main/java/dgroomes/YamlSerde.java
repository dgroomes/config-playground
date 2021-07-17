package dgroomes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.List;

/**
 * A serializer and deserializer (often referred to as a "serde") for serializing a list of Java objects into a YAML
 * document and by converse, deserializing a YAML document into a list of Java objects.
 * <p>
 * This is a toy class that exists to illustrate Jackson's YAML support.
 */
public class YamlSerde {

    public enum Fruit {
        APPLE, BANANA, ORANGE
    }

    private final ObjectMapper objectMapper;

    public YamlSerde() {
        this(new ObjectMapper(new YAMLFactory()));
    }

    public YamlSerde(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Serialize a list of Fruit objects into a YAML string
     *
     * @param fruits list of fruits to serialize
     * @return the list of fruits serialized as a YAML-formatted string
     */
    public String serialize(List<Fruit> fruits) {
        try {
            return objectMapper.writeValueAsString(fruits);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize the list of Fruit objects", e);
        }
    }

    TypeReference<List<Fruit>> LIST_FRUIT_TYPE = new TypeReference<List<Fruit>>() {
    };

    /**
     * Deserialize a YAML document of fruits into a list of fruit objects.
     *
     * @param yaml the YAMl document to deserialize
     * @return a list of fruit objects
     */
    public List<Fruit> deserialize(String yaml) {
        try {
            return objectMapper.readValue(yaml, LIST_FRUIT_TYPE);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to deserialize the YAML document of fruit into a list of objects", e);
        }
    }
}
