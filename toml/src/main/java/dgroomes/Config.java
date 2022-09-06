package dgroomes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * An application configuration abstraction backed by a TOML file.
 * <p>
 * This class takes care of the implementation detail of deserializing from a TOML configuration file into Java values.
 */
public class Config {

  private static final Logger log = LoggerFactory.getLogger(Config.class);
  private static final String CONFIG_FILE = "/config.toml";

  public final int repetitions;
  public final String repeatingMessage;
  public final int pause; // The unit is seconds

  public Config() {
    TomlMapper tomlMapper = new TomlMapper();
    ObjectNodeWrapper objectNodeWrapper;

    { // Load and parse the config file
      var stream = this.getClass().getResourceAsStream(CONFIG_FILE);
      if (stream == null) {
        throw new IllegalStateException(String.format("Failed to find the classpath resource '%s'", CONFIG_FILE));
      }

      try {
        // Interestingly, the word "JSON" has entered the scene even though we are dealing with a TOML document.
        // This is an artifact of history. Jackson's API centrally features the `ObjectMapper` type, which codes to JSON
        // concepts. Years after this API was created, Jackson added TOML support and the TOML implementation literally
        // extends the ObjectMapper implementation and so here we are (and I've come to really understand and love the
        // `JsonNode` API!).
        var jsonNode = tomlMapper.readTree(stream);
        if (jsonNode instanceof ObjectNode objectNode) {
          objectNodeWrapper = new ObjectNodeWrapper(objectNode);
        } else {
          var msg2 = "Unexpected root type found from deserializing the TOML document. Expected to find an ObjectNode but found type '%s'".formatted(jsonNode.getClass());
          throw new IllegalStateException(msg2);
        }
      } catch (IOException e) {
        throw new IllegalStateException("Error reading and deserializing the TOML file", e);
      }
      log.info("Loaded the following top-level keys from the config file: {}", objectNodeWrapper);
    }

    repetitions = objectNodeWrapper.at("/app-config/repetitions").asInt();
    repeatingMessage = objectNodeWrapper.at("/app-config/repeating-message").asText();
    pause = objectNodeWrapper.at("/app-config/pause").asInt();
  }

  /**
   * Convenience wrapper over a {@code JsonNode} object.
   */
  private static class ObjectNodeWrapper {

    private final ObjectNode objectNode;

    private ObjectNodeWrapper(ObjectNode objectNode) {
      this.objectNode = objectNode;
    }

    /**
     * Find the value at the given JSON pointer expression of the underlying {@link JsonNode}.
     *
     * @param pointer - The JSON pointer expression for which to find a value in the underlying {@link JsonNode}
     * @return non-null value found from the underlying {@link JsonNode}
     * @throws IllegalStateException if no value was found at the pointer
     */
    public JsonNode at(String pointer) {
      var found = objectNode.at(pointer);
      if (found instanceof MissingNode) {
        var msg = String.format("Expected to find a value for the JSON pointer expression '%s' but found nothing", pointer);
        throw new IllegalStateException(msg);
      }

      return found;
    }

    /**
     * The 'toString' implementation returns a listing of the top-level keys.
     * <p>
     * Note: this would probably be a lot more useful if printed the whole key set, including keys nested in other
     * objects.
     */
    @Override
    public String toString() {
      Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(objectNode.fieldNames(), Spliterator.ORDERED);
      return StreamSupport.stream(spliterator, false)
              .collect(Collectors.joining(", "));
    }
  }
}
