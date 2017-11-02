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

    override var revision: Int? = null

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