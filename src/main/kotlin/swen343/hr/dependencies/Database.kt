package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.util.Updatable
import java.sql.Connection

/**
 * Created by ben on 10/29/17.
 */
@ImplementedBy(DatabaseMySql::class)
interface Database : Connection {

    /**
     * The connection to the database.
     */
    val connection: Connection
}
