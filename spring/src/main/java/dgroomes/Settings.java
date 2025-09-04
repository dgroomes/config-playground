package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

public class Settings {

    private static final Logger log = LoggerFactory.getLogger(Settings.class);

    public final String repeatingMessage;
    public final long pause;
    public final int repetitions;
    public final String finalMessage;

    public Settings(Environment environment) {
        this.repeatingMessage = environment.getProperty("repeatingMessage");
        this.pause = environment.getProperty("pause", Long.class);
        this.repetitions = environment.getProperty("repetitions", Integer.class);
        this.finalMessage = environment.getProperty("finalMessage");

        log.debug("Loaded settings: repetitions={}, pause={}ms", repetitions, pause);
    }
}
