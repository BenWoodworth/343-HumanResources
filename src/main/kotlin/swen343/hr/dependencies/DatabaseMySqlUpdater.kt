package swen343.hr.dependencies

import swen343.hr.util.Updater

class DatabaseMySqlUpdater : Updater<DatabaseMySql>(
        {
            it.connection.createStatement().executeQuery(
                    """
                    DROP TABLE IF EXISTS Attributes;
                    CREATE TABLE Attributes (
                      id            INT           NOT NULL,
                      attribute     VARCHAR(20)   NOT NULL UNIQUE,
                      value         VARCHAR(20)   NOT NULL,
                      PRIMARY KEY (attribute)
                    );

                    DROP TABLE IF EXISTS Users;
                    CREATE TABLE Users (
                      id            INT           NOT NULL AUTO_INCREMENT,
                      username      VARCHAR(20)   NOT NULL UNIQUE,
                      passwordHash  VARCHAR(20)   NOT NULL,
                      PRIMARY KEY (id)
                    );

                    DROP TABLE IF EXISTS Employees;
                    CREATE TABLE Employees (
                      id            INT           NOT NULL AUTO_INCREMENT,
                      userId        INT           NOT NULL,
                      firstName     VARCHAR(100)  NOT NULL,
                      lastName      VARCHAR(100)  NOT NULL,
                      title         VARCHAR(100)  NOT NULL,
                      department    VARCHAR(100)  NOT NULL,
                      salary        INT           NOT NULL,
                      phoneNumber   VARCHAR(10)   NOT NULL,
                      email         VARCHAR(100)  NOT NULL,
                      address       VARCHAR(250)  NOT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (userId) REFERENCES Users(id)
                    );
                """
            )
        }
) {

    override fun initialize(updatable: DatabaseMySql) {}

    override fun finalize(updatable: DatabaseMySql) {}
}