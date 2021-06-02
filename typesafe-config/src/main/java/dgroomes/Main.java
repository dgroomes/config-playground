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
        var settings = new Settings(ConfigFactory.load());

        for (int i = 0; i < settings.repetitions; i++) {
            log.info(settings.message);
            //noinspection BusyWait
            Thread.sleep(settings.pause);
        }
    }
}
