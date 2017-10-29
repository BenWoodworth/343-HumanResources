package swen343.hr.dependencies

import java.sql.Connection
import java.sql.DriverManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HrDatabaseMySql @Inject constructor(
        hrProperties: HrProperties
) : HrDatabase {

    override val connection: Connection

    init {
        // Load driver
        Class.forName("com.mysql.jdbc.Driver")

        connection = DriverManager.getConnection(
                hrProperties.dbUrl,
                hrProperties.dbUser,
                hrProperties.dbPass
        )
    }
}