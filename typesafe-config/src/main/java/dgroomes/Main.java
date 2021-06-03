package dgroomes;

import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Showcasing the Typesafe Config library via a simple Java program.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        Settings settings = initSettings();

        for (int i = 0; i < settings.repetitions; i++) {
            log.info(settings.repeatingMessage);
            //noinspection BusyWait
            Thread.sleep(settings.pause);
        }
        log.info(settings.finalMessage);
    }

    private static Settings initSettings() {
        // Allow configuration values to be overridden via environment variables
        // See https://github.com/lightbend/config#optional-system-or-env-variable-overrides
        System.setProperty("config.override_with_env_vars", "true");

        return new Settings(ConfigFactory.load());
    }
}
