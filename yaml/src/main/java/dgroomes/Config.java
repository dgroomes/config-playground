package dgroomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * An application configuration abstraction backed by a YAML file.
 *
 * This class takes care of the implementation detail of deserializing from the YAML configuration file into Java values.
 */
public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);

    public final int repetitions;
    public final String repeatingMessage;
    public final int pause; // The unit is seconds

    public Config() {
        var yaml = new Yaml();
        Map<String, Object> map;

        {
            var stream = this.getClass().getResourceAsStream("/config.yml");
            var raw = yaml.load(stream);
            map = (Map<String, Object>) raw;
            log.info("Loaded the following data from the config file: {}", map);
        }

        repetitions = (int) map.get("repetitions");
        repeatingMessage = (String) map.get("repeating-message");
        pause = (int) map.get("pause");
    }
}
