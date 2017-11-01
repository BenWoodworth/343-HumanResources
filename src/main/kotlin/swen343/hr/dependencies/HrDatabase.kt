package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import java.sql.Connection

/**
 * Created by ben on 10/29/17.
 */
@ImplementedBy(HrDatabaseMySql::class)
interface HrDatabase {

    val connection: Connection
}
