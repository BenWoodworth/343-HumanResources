package swen343.hr.dependencies

import swen343.hr.util.Updatable
import swen343.hr.util.connect
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseMySql @Inject constructor(
        private val hrProperties: Config,
        databaseMySqlUpdater: DatabaseMySqlUpdater
) : Database, Updatable {

    override var revision: Int?
        get() {
            try {
                connect {
                    createStatement().executeQuery(
                            "SELECT value FROM Attributes WHERE attribute='revision';"
                    ).use {
                        if (it.next()) {
                            return it.getString("value").toInt()
                        }
                    }
                }
            } catch (exception: SQLException) {
            }

            return null
        }
        set(value) {
            connect {
                prepareStatement(
                        "REPLACE INTO Attributes VALUES('revision', ?);"
                ).apply {
                    setString(1, value?.toString())
                }.execute()
            }
        }

    init {
        Class.forName("com.mysql.jdbc.Driver")
        databaseMySqlUpdater.update(this)
    }

    override fun createConnection(): Connection {
        return DriverManager.getConnection(
                hrProperties.databaseUrl,
                hrProperties.databaseUser,
                hrProperties.databasePass
        )
    }
}