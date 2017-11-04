package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import java.sql.Statement

@Singleton
class EmployeeServiceMySql @Inject constructor(
        private val database: DatabaseMySql,
        private val userService: UserService
) : EmployeeService {

    override fun getEmployees(): List<Employee> {
        database.connection.createStatement().executeQuery(
                "SELECT * FROM Employees;"
        ).use {
            val employees = mutableListOf<Employee>()
            while (it.next()) {
                employees += Employee(
                        id = it.getInt("id"),
                        user = userService.getUser(it.getInt("userId"))!!,
                        firstName = it.getString("firstName"),
                        lastName = it.getString("lastName"),
                        title = it.getString("title"),
                        department = it.getString("department"),
                        salary = it.getInt("salary"),
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
                "SELECT * FROM Employees WHERE username=?;"
        ).apply {
            setString(0, username)
        }.executeQuery().use {
            return if (!it.next()) {
                Employee(
                        id = it.getInt("id"),
                        user = userService.getUser(it.getInt("userId"))!!,
                        firstName = it.getString("firstName"),
                        lastName = it.getString("lastName"),
                        title = it.getString("title"),
                        department = it.getString("department"),
                        salary = it.getInt("salary"),
                        phoneNumber = it.getString("phoneNumber"),
                        email = it.getString("email"),
                        address = it.getString("address")
                )
            } else {
                null
            }
        }
    }

    override fun addEmployee(employee: Employee): Employee {
        database.connection.prepareStatement(
                """
                    INSERT INTO Employees (
                      id,
                      userId,
                      firstName,
                      lastName,
                      title,
                      department,
                      salary,
                      phoneNumber,
                      email,
                      address
                    ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """,
                Statement.RETURN_GENERATED_KEYS
        ).apply {
            setInt(1, employee.user.id)
            setString(2, employee.firstName)
            setString(3, employee.lastName)
            setString(4, employee.title)
            setString(5, employee.department)
            setInt(6, employee.salary)
            setString(7, employee.phoneNumber)
            setString(8, employee.email)
            setString(9, employee.address)
        }.apply {
            executeQuery()
        }.generatedKeys.use {
            if (it.next()) {
                return employee.copy(
                        id = it.getInt(1)
                )
            } else {
                TODO("Error")
            }
        }
    }

    override fun editEmployee(employee: Employee) {
        database.connection.prepareStatement(
                """
                    REPLACE INTO Employees (
                      id,
                      userId,
                      firstName,
                      lastName,
                      title,
                      department,
                      salary,
                      phoneNumber,
                      email,
                      address
                    ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """
        ).apply {
            setInt(0, employee.id)
            setInt(1, employee.user.id)
            setString(2, employee.firstName)
            setString(3, employee.lastName)
            setString(4, employee.title)
            setString(5, employee.department)
            setInt(6, employee.salary)
            setString(7, employee.phoneNumber)
            setString(8, employee.email)
            setString(9, employee.address)
        }.execute()
    }

    override fun deleteEmployee(employee: Employee) {
        database.connection.prepareStatement(
                "DELETE FROM Employees WHERE id=?;"
        ).apply {
            setInt(0, employee.id)
        }.execute()
    }
}

