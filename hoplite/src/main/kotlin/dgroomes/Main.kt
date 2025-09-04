package dgroomes

import com.sksamuel.hoplite.ConfigLoaderBuilder
import org.slf4j.LoggerFactory

/**
 * Showcasing the Hoplite configuration library via a "hello world"-style Kotlin program.
 */
object Main {

    private val log = LoggerFactory.getLogger(Main::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val settings = initSettings()

        repeat(settings.repetitions) {
            log.info(settings.repeatingMessage)
            Thread.sleep(settings.pause)
        }
        log.info(settings.finalMessage)
    }

    private fun initSettings(): Settings {
        return ConfigLoaderBuilder.default().build().loadConfigOrThrow<Settings>("/application.properties")
    }
}
