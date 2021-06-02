package dgroomes;

import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    @BeforeEach
    void setUp() {
        // Clean up any side-effects that may be lingering between test executions.
        System.clearProperty("repetitions");
    }

    @Disabled("For some reason Typesafe Config is using a cached version of the 'repetitions' system property. At runtime I can see that the system property is 3 but the config value is 4")
    @Test
    void setting() {
        var settings = new Settings(ConfigFactory.load());

        assertEquals(3, settings.repetitions);
    }

    /**
     * Supplying a configuration property via system property should be taken at a higher precedence. Think of this like
     * "overriding" but I find that metaphor confusing because I'm pretty sure Typesafe Config doesn't find a value and
     * then find another one and override the value. I think it just uses a search path and uses the first value it finds.
     * There is no actual "act of overriding".
     */
    @Test
    void configBySystemProperty() {
        System.setProperty("repetitions", "4");
        var settings = new Settings(ConfigFactory.load());

        assertEquals(4, settings.repetitions);
    }
}
