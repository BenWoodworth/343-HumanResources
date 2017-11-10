package swen343.hr.dependencies

import swen343.hr.util.Updater

class DatabaseMySqlUpdater : Updater<DatabaseMySql>({
    connect {
        createStatement().execute(
                "DROP TABLE IF EXISTS Attributes, Employees, Users;"
        )

        createStatement().execute(
                """
                    CREATE TABLE Attributes (
                      attribute     VARCHAR(20)   NOT NULL,
                      value         VARCHAR(20)   NOT NULL,
                      PRIMARY KEY (attribute)
                    );
                """
        )

        createStatement().execute(
                """
                    CREATE TABLE Users (
                      id            INT           NOT NULL AUTO_INCREMENT,
                      username      VARCHAR(20)   NOT NULL UNIQUE,
                      passwordHash  VARCHAR(44)   NOT NULL,
                      PRIMARY KEY (id)
                    );
                """
        )

        createStatement().execute(
                """
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
}, {
    connect {
        createStatement().execute(
                "DROP TABLE IF EXISTS Permissions;"
        )

        createStatement().execute(
                """
                    CREATE TABLE Permissions (
                      id            INT           NOT NULL AUTO_INCREMENT,
                      userId        INT           NOT NULL,
                      permission    VARCHAR(100)  NOT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (userId) REFERENCES Users(id)
                    );
                """
        )
    }
}, {
    connect {
        createStatement().execute(
                "DROP TABLE IF EXISTS Sessions;"
        )

        createStatement().execute(
                """
                    CREATE TABLE Sessions (
                      id            INT           NOT NULL AUTO_INCREMENT,
                      sessionId     VARCHAR(44)   NOT NULL UNIQUE,
                      userId        INT           NOT NULL,
                      expiration    DATETIME      NULL,
                      ipAddress     VARCHAR(40)   NULL,
                      FOREIGN KEY (userId) REFERENCES Users(id)
                    );
                """
        )
    }
}) {

    override fun initialize(updatable: DatabaseMySql) {}

    override fun finalize(updatable: DatabaseMySql) {}
}