package dgroomes;

import com.typesafe.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * An abstraction over all configuration (or, "settings") for the program. The implementation uses the Typesafe Config
 * library and follows one of the recommended idioms of creating a custom class named "Settings" which is instantiated on
 * startup and immediately throws an exception if any expected settings could not be found or are of an unexpected type.
 */
public class Settings {

    private static final Logger log = LoggerFactory.getLogger(Settings.class);
    private final Config config;

    public final String repeatingMessage;
    public final long pause;
    public final int repetitions;
    public final String finalMessage;

    public Settings(Config config) {
        // The config object should be initialized by the main program body
        this.config = config;

        // Use the convenience type-specific methods like "getInt" and "getDuration" to find configuration values by name
        // and convert them to the specified Java type.
        this.repeatingMessage = config.getString("repeating-message");
        this.pause = config.getDuration("pause", TimeUnit.MILLISECONDS);

        // Notice the "debug" method call here. See its method body below.
        this.repetitions = config.getInt(debug("repetitions"));
        this.finalMessage = config.getString(debug("final-message"));
    }

    /**
     * Typesafe Config has a good debugging story. Use the generic "getValue" method to find configuration values. This
     * is useful because it returns a ConfigValue instance from which you can glean information about the configuration
     * value like which file it was sourced from.
     * <p>
     * Be careful when using this so you don't print sensitive information like passwords in a shared logging environment.
     * <p>
     * This is especially useful in situations with multiple cascading sources of overriding configuration like cloud config
     * files, classpath config files, external file system files, and system properties. It can be desperately challenging
     * to debug configuration in those environments. This is a welcome feature!
     *
     * @param path the path to the property
     * @return the same path
     */
    private String debug(String path) {
        var value = config.getValue(path);
        log.debug("Configuration debug info:\n\tpath='{}'\n\ttoString={}\n\torigin={}\n", path, value, value.origin());
        return path;
    }
}
