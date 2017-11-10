package swen343.hr.util

import swen343.hr.dependencies.Database
import java.sql.Connection

/**
 * Created by ben on 11/10/17.
 */

inline fun Database.connect(block: Connection.() -> Unit) {
    createConnection().use {
        block(it)
    }
}
