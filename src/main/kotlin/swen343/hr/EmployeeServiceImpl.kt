package swen343.hr

import swen343.hr.datasource.MySQLDatabase
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class EmployeeServiceImpl : EmployeeServiceInt {

    override fun addEmployee() {

        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = MySQLDatabase.conn!!.createStatement()
            resultset = stmt!!.executeQuery("INSERT INTO employees(id,firstName,lastName,title,department,salary,phoneNumber,email,address) VALUE(?,?,?,?,?,?,?,?,?);")

            if (stmt.execute("INSERT INTO employees(id,firstName,lastName,title,department,salary,phoneNumber,email,address) VALUE(?,?,?,?,?,?,?,?,?);")) {
                resultset = stmt.resultSet //remove if borked.
            }

            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (MySQLDatabase.conn != null) {
                try {
                    MySQLDatabase.conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                MySQLDatabase.conn = null
            }
        }

    }

    override fun editEmployee(employee: Employee) {

        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = MySQLDatabase.conn!!.createStatement()
            resultset = stmt!!.executeQuery("UPDATE employees SET id =employee.id, firstName = ?, lastName = ?, title = ?, department = ?, salary = ?, phoneNumber = ?, email = ?, address = ? ")

            if (stmt.execute("UPDATE employees SET id =employee.id, firstName = ?, lastName = ?, title = ?, department = ?, salary = ?, phoneNumber = ?, email = ?, address = ?")) {
                resultset = stmt.resultSet //remove if borked.
            }

            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (MySQLDatabase.conn != null) {
                try {
                    MySQLDatabase.conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                MySQLDatabase.conn = null
            }
        }
    }

    override fun deleteEmployee(employee: Employee) {
        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = MySQLDatabase.conn!!.createStatement()
            resultset = stmt!!.executeQuery("DELETE FROM employee [WHERE id=employee.id]")

            if (stmt.execute("DELETE FROM employee [WHERE id=employee.id]")) {
                resultset = stmt.resultSet //remove if borked.
            }

            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (MySQLDatabase.conn != null) {
                try {
                    MySQLDatabase.conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                MySQLDatabase.conn = null
            }
        }
    }
}

