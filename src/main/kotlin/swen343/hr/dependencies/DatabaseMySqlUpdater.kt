package swen343.hr.dependencies

import swen343.hr.util.Updater

class DatabaseMySqlUpdater : Updater<DatabaseMySql>(
        {
            it.connection.createStatement().executeQuery(
                """
                    DROP TABLE IF EXISTS `Attributes`;
                    CREATE TABLE Attributes (
                      attribute   VARCHAR(20)   NOT NULL,
                      value       VARCHAR(20)   NOT NULL,
                      PRIMARY KEY (attribute)
                    );

                    DROP TABLE IF EXISTS Employees;
                    CREATE TABLE Employees (
                      username    VARCHAR(20)   NOT NULL,
                      firstName   VARCHAR(100)  NOT NULL,
                      lastName    VARCHAR(100)  NOT NULL,
                      title       VARCHAR(100)  NOT NULL,
                      department  VARCHAR(100)  NOT NULL,
                      salary      INT           NOT NULL,
                      phoneNumber VARCHAR(10)   NOT NULL,
                      email       VARCHAR(100)  NOT NULL,
                      address     VARCHAR(250)  NOT NULL,
                      PRIMARY KEY (username)
                    );
                """
            )
        }
) {

    override fun initialize(updatable: DatabaseMySql) {}

    override fun finalize(updatable: DatabaseMySql) {}
}