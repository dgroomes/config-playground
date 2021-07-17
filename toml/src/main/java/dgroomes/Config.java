package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomlj.Toml;
import org.tomlj.TomlTable;

import java.io.IOException;
import java.util.Objects;

/**
 * An application configuration abstraction backed by a TOML file.
 * <p>
 * This class takes care of the implementation detail of deserializing from a TOML configuration file into Java values.
 */
public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String CONFIG_FILE = "/config.toml";

    public final long repetitions;
    public final String repeatingMessage;
    public final long pause; // The unit is seconds

    public Config() {
        TomlTableWrapper topLevel;

        { // Load and parse the config file
            var stream = this.getClass().getResourceAsStream(CONFIG_FILE);
            if (stream == null) {
                throw new IllegalStateException(String.format("Failed to find the classpath resource '%s'", CONFIG_FILE));
            }
            TomlTable parseResult;
            try {
                parseResult = Toml.parse(stream);
            } catch (IOException e) {
                throw new IllegalStateException("Error reading the TOML file", e);
            }
            log.info("Loaded the following keys from the config file: {}", parseResult.dottedKeySet());
            topLevel = new TomlTableWrapper(parseResult);
        }


        var appConfig = new TomlTableWrapper(topLevel.get("app-config"));
        repetitions = appConfig.get("repetitions");
        repeatingMessage = appConfig.get("repeating-message");
        pause = appConfig.get("pause");
    }

    /**
     * Convenience wrapper over a TomlTable object.
     */
    private static class TomlTableWrapper {

        private final TomlTable tomlTable;

        private TomlTableWrapper(TomlTable tomlTable) {
            this.tomlTable = tomlTable;
        }

        /**
         * Find the value for the given key in the underlying TomlTable.
         *
         * @param key the key to find a value from in the underlying TomlTable
         * @param <T> the type to cast it to. This can only be the types that TOML supports: string, long, etc.
         * @return non-null value found from the underlying TomlTable object
         * @throws NullPointerException if no value was found for the given key
         */
        public <T> T get(String key) {
            var found = tomlTable.get(key);
            Objects.requireNonNull(found, String.format("Expected to find a value for key '%s' but found nothing", key));
            //noinspection unchecked
            return (T) found;
        }
    }
}
