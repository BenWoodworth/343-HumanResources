package swen343.hr.dependencies

import com.google.inject.Singleton
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * Created by ben on 10/23/17.
 */
@Singleton
class HrPropertiesFile : HrProperties {

    val configComment = """
        This is a comment
    """

    private val propertiesPath = Paths.get("config.properties")
    private val properties: Properties = Properties()

    private var configRevision: Int
        get() = properties.getProperty("configRevision")?.toIntOrNull() ?: 0
        set(value) {
            properties.setProperty("configRevision", value.toString())
        }

    init {
        if (!Files.exists(propertiesPath)) {
            Files.createFile(propertiesPath)
        }

        val reader = Files.newBufferedReader(propertiesPath)
        properties.load(reader)
        reader.close()

        update()
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

    private fun update() {
        // Whenever changes are made to the config, a fun()
        // should be added to this list to make the config
        // future-proof.
        val updates = listOf(
                fun() {
                    // Initial properties file setup
                    properties.clear()


                    properties["port"] = "1234"
                    properties["use-dummy-services"] = "true"
                    properties["database.url"] = ""
                    properties["database.user"] = ""
                    properties["database.pass"] = ""
                }
        )

        // Apply updates
        while (configRevision < updates.size) {
            updates[configRevision]()
            configRevision++
        }

        // Save file
        val writer = Files.newBufferedWriter(propertiesPath)
        properties.store(writer, configComment)
        writer.close()
    }
}
