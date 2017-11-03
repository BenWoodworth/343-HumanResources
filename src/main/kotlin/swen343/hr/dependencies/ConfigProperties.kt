package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.util.Updatable
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * Created by ben on 10/23/17.
 */
@Singleton
class ConfigProperties @Inject constructor(
        configPropertiesUpdater: ConfigPropertiesUpdater
) : Config, Updatable {

    val configComment = """
        Human Resources properties file
        Do not change config-revision!
    """.trimIndent()

    private val propertiesPath = Paths.get("config.properties")
    val properties: Properties = Properties()

    override var revision: Int?
        get() = properties.getProperty("config-revision")?.toIntOrNull()
        set(value) {
            properties.setProperty("config-revision", value.toString())
        }

    init {
        if (!Files.exists(propertiesPath)) {
            Files.createFile(propertiesPath)
        }

        val reader = Files.newBufferedReader(propertiesPath)
        properties.load(reader)
        reader.close()

        configPropertiesUpdater.update(this)
    }

    fun save() {
        val writer = Files.newBufferedWriter(propertiesPath)
        properties.store(writer, configComment)
        writer.close()
    }

    override val port: Int
        get() = properties.getProperty("port").toInt()

    override val useDummyServices: Boolean
        get() =
            properties.getProperty("use-dummy-services").toBoolean()

    override val databaseUrl: String
        get() = properties.getProperty("database.url")

    override val databaseUser: String
        get() = properties.getProperty("database.user")

    override val databasePass: String
        get() = properties.getProperty("database.pass")
}
