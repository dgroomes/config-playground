package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Run a simple program configured with some properties encapsulated in a configuration class.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        var config = new Config();

        var msg = config.repeatingMessage;
        var pauseMillis = config.pause * 1000;
        var repetitions = config.repetitions;

        for (int i = 0; i < repetitions; i++) {
            log.info(msg);
            Thread.sleep(pauseMillis);
        }
    }
}
