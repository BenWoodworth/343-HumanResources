package swen343.hr.dependencies

import swen343.hr.util.Updatable
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseMySql @Inject constructor(
        hrProperties: Config,
        databaseMySqlUpdater: DatabaseMySqlUpdater
) : Database, Updatable {

    override val connection: Connection

    override var revision: Int?
        get() {
            try {
                connection.createStatement().executeQuery(
                        "SELECT value FROM Attributes WHERE attribute=revision;"
                ).use {
                    if (!it.next()) {
                        return it.getString("value").toInt()
                    }
                }
            } catch (exception: SQLException) {}

            return null
        }
        set(value) {
            connection.prepareStatement(
                    """
                    REPLACE INTO Attributes (value)
                      VALUES('revision', ?);
                """
            ).apply {
                setString(1, value?.toString())
            }.execute()
        }

    init {
        Class.forName("com.mysql.jdbc.Driver")

        connection = DriverManager.getConnection(
                hrProperties.databaseUrl,
                hrProperties.databaseUser,
                hrProperties.databasePass
        )

        databaseMySqlUpdater.update(this)
    }
}