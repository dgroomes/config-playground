package dgroomes;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.concurrent.TimeUnit;

/**
 * An abstraction over all configuration (or, "settings") for the program. The implementation uses the Typesafe Config
 * library and follows one of the recommended idioms of creating a custom class named "Settings" which is instantiated on
 * startup and immediately throws an exception if any expected settings could not be found or are of the wrong type.
 */
public class Settings {

    private static final Config config;

    static {
        config = ConfigFactory.load();
    }

    public static String message = config.getString("message");
    public static int repetitions = config.getInt("repetitions");
    public static long pause = config.getDuration("pause", TimeUnit.MILLISECONDS);
}
