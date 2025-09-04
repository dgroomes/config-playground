package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Showcasing Spring's core property system via a "hello world"-style program.
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        var settings = initSettings();

        for (int i = 0; i < settings.repetitions; i++) {
            log.info(settings.repeatingMessage);
            Thread.sleep(settings.pause);
        }
        log.info(settings.finalMessage);
    }

    /**
     * TODO get rid of Settings. Just code to the environment directly.
     * @return
     */
    private static Settings initSettings() {
        var environment = new StandardEnvironment();

        Properties props;
        try {
            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }

        environment.getPropertySources().addLast(new PropertiesPropertySource("application", props));

        return new Settings(environment);
    }
}
