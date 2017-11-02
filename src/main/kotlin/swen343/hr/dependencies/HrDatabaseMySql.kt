package swen343.hr.dependencies

import swen343.hr.util.Updatable
import java.sql.Connection
import java.sql.DriverManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HrDatabaseMySql @Inject constructor(
        hrProperties: Config
) : HrDatabase, Updatable {

    override val connection: Connection

    override var revision: Int?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    init {
        Class.forName("com.mysql.jdbc.Driver")

        connection = DriverManager.getConnection(
                hrProperties.databaseUrl,
                hrProperties.databaseUser,
                hrProperties.databasePass
        )
    }
}