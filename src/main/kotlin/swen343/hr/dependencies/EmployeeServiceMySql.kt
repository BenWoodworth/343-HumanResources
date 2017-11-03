package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee

@Singleton
class EmployeeServiceMySql @Inject constructor(
        private val database: DatabaseMySql
) : EmployeeService {

    override fun getEmployees(): List<Employee> {
        database.connection.createStatement().executeQuery(
                """
                    SELECT * FROM Employees;
                """
        ).use {
            val employees = mutableListOf<Employee>()
            while (it.next()) {
                employees += Employee(
                        username = it.getString("username"),
                        firstName = it.getString("firstName"),
                        lastName = it.getString("lastName"),
                        title = it.getString("title"),
                        department = it.getString("department"),
                        salary = it.getString("salary"),
                        phoneNumber = it.getString("phoneNumber"),
                        email = it.getString("email"),
                        address = it.getString("address")
                )
            }
            return employees
        }
    }

    override fun getEmployee(username: String): Employee? {
        database.connection.prepareStatement(
                """
                    SELECT * FROM Employees WHERE username=?;
                """
        ).apply {
            setString(0, username)
        }.executeQuery().use {
            return if (!it.next()) {
                Employee(
                        username = it.getString("username"),
                        firstName = it.getString("firstName"),
                        lastName = it.getString("lastName"),
                        title = it.getString("title"),
                        department = it.getString("department"),
                        salary = it.getString("salary"),
                        phoneNumber = it.getString("phoneNumber"),
                        email = it.getString("email"),
                        address = it.getString("address")
                )
            } else {
                null
            }
        }
    }

    override fun updateEmployee(employee: Employee) {
        database.connection.prepareStatement(
                """
                    REPLACE INTO Employees (
                      username,
                      firstName,
                      lastName,
                      title,
                      department,
                      salary,
                      phoneNumber,
                      email,
                      address
                    ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
                """
        ).apply {
            setString(0, employee.username)
            setString(1, employee.firstName)
            setString(2, employee.lastName)
            setString(3, employee.title)
            setString(4, employee.department)
            setString(5, employee.salary)
            setString(6, employee.phoneNumber)
            setString(7, employee.email)
            setString(8, employee.address)
        }.execute()
    }

    override fun deleteEmployee(username: String) {
        database.connection.prepareStatement(
                """
                    DELETE FROM Employees WHERE username=?;
                """
        ).apply {
            setString(0, username)
        }.execute()
    }
}

