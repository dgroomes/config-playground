package dgroomes;

import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    @BeforeEach
    void setUp() {
        // Clean up any side-effects that may be lingering between test executions.
        System.clearProperty("repetitions");

        // Beware: Typesafe Config will cache data. This is a nice feature for performance but unfortunately it goes some
        // ways to negate the understandability of the library.
        // More concerning, this call doesn't even do the trick. For some reason, I have to make this method call inside
        // the "configBySystemProperty" test method body itself to really clear/refresh the cache. I think it's a
        // classloader thing, and I think there are multiple classloaders in the mix because of JUnit.
        ConfigFactory.invalidateCaches();
    }

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
        ConfigFactory.invalidateCaches(); // see the related note in the "setUp" method
        var settings = new Settings(ConfigFactory.load());

        assertEquals(4, settings.repetitions);
    }
}
