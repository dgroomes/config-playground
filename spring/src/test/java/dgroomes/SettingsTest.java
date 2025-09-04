package dgroomes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    private StandardEnvironment environment;

    @BeforeEach
    void setUp() throws IOException {
        environment = new StandardEnvironment();
        Properties props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
        environment.getPropertySources().addFirst(new PropertiesPropertySource("application", props));
    }

    @Test
    void defaultSettings() {
        var settings = new Settings(environment);

        assertEquals(3, settings.repetitions);
    }

    @Test
    void programmaticOverride() {
        // Demonstrate how to override properties programmatically using MapPropertySource.
        // This is the Spring way to inject configuration values in tests or other scenarios.
        Map<String, Object> overrides = Map.of("repetitions", 5);
        environment.getPropertySources().addFirst(new MapPropertySource("overrides", overrides));

        var settings = new Settings(environment);

        assertEquals(5, settings.repetitions);
    }
}
