package dgroomes

import org.slf4j.LoggerFactory

/**
 * An abstraction over all configuration (or, "settings") for the program.
 */
data class Settings(
    val repeatingMessage: String,
    val pause: Long,
    val repetitions: Int,
    val finalMessage: String
) {
    companion object {
        private val log = LoggerFactory.getLogger(Settings::class.java)
    }

    init {
        log.debug("Loaded settings: repetitions={}, pause={}ms", repetitions, pause)
    }
}
