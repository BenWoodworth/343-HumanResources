package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import java.sql.Connection
import java.sql.DriverManager

/**
 * Created by ben on 10/29/17.
 */
@Singleton
class HrDbConnection @Inject constructor(
        private val hrProperties: HrProperties
) : Connection by DriverManager.getConnection(
        hrProperties.dbUrl,
        hrProperties.dbUser,
        hrProperties.dbPass
)
