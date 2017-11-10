package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import java.sql.Connection

/**
 * Created by ben on 10/29/17.
 */
@ImplementedBy(DatabaseMySql::class)
abstract class Database {

    abstract fun createConnection(): Connection

    inline fun connect(block: Connection.() -> Unit) {
        createConnection().use {
            block(it)
        }
    }
}
