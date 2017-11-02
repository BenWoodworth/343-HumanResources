package swen343.hr.dependencies

import swen343.hr.util.Updater

class DatabaseMySqlUpdater : Updater<DatabaseMySql>(

) {

    override fun initialize(updatable: DatabaseMySql) {
        val statement = updatable.connection.createStatement()

        val results = statement.executeQuery("""
            SELECT table_name FROM information_schema.tables;
        """)

        results
    }

    override fun finalize(updatable: DatabaseMySql) {}
}