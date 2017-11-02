package swen343.hr.dependencies

import swen343.hr.util.Updater

class DatabaseMySqlUpdater : Updater<DatabaseMySql>(
        {
            it.connection.createStatement().executeQuery("""
                    CREATE TABLE `Employees` (
                      `username`    varchar(20)   NOT NULL,
                      `firstName`   varchar(100)  NOT NULL,
                      `lastName`    varchar(100)  NOT NULL,
                      `title`       varchar(100)  NOT NULL,
                      `department`  varchar(100)  NOT NULL,
                      `salary`      int           NOT NULL,
                      `phoneNumber` varchar(10)   NOT NULL,
                      `email`       varchar(100)  NOT NULL,
                      `address`     varchar(250)  NOT NULL,
                      PRIMARY KEY (`username`)
                    );
            """)
        }
) {

    override fun initialize(updatable: DatabaseMySql) {
        // Drop all the tables

        val statement = updatable.connection.createStatement()

        val results = statement.executeQuery("""
            SELECT table_name FROM information_schema.tables;
        """)

        results // TODO
    }

    override fun finalize(updatable: DatabaseMySql) {}
}