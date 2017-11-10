package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import java.sql.Connection

/**
 * Created by ben on 10/29/17.
 */
@ImplementedBy(DatabaseMySql::class)
interface Database {

    fun createConnection(): Connection
}
