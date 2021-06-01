package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Showcasing the Typesafe Config library via a simple Java program.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Settings.repetitions; i++) {
            log.info(Settings.message);
            //noinspection BusyWait
            Thread.sleep(Settings.pause);
        }
    }
}
