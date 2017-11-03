package swen343.hr.dependencies

import swen343.hr.util.Updatable
import java.sql.Connection
import java.sql.DriverManager
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
            connection.createStatement().executeQuery(
                    "SELECT value FROM Attributes WHERE attribute=revision;"
            ).use {
                return if (!it.next()) {
                    it.getString("value").toInt()
                } else {
                    null
                }
            }
        }
        set(value) {
            connection.prepareStatement(
                    "SELECT * FROM Attributes WHERE username=?;"
            ).apply {
                setString(0, value?.toString())
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