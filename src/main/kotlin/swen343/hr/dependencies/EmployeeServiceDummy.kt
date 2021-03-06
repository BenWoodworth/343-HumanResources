package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import swen343.hr.models.User

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class EmployeeServiceDummy @Inject constructor(
        userService: UserService,
        hashService: HashProvider
) : EmployeeService {

    private val employees = mutableListOf<Employee>()

    override fun getEmployees(): List<Employee> {
        return employees
                .sortedBy { it.id }
                .toList()
    }

    override fun getEmployee(username: String): Employee? {
        return employees.firstOrNull { it.user.username == username }
    }

    override fun addEmployee(employee: Employee): Employee {
        val id = employees
                .map { it.id + 1 }
                .maxBy { it} ?: 0

        val newEmployee = Employee(
                id = id,
                user = employee.user,
                firstName = employee.firstName,
                lastName = employee.lastName,
                title = employee.title,
                department = employee.department,
                salary = employee.salary,
                phoneNumber = employee.phoneNumber,
                email = employee.email,
                address = employee.address
        )

        employees += newEmployee

        return newEmployee
    }

    override fun editEmployee(employee: Employee) {
        employees.removeIf { it.id == employee.id }
        employees += employee
    }

    override fun deleteEmployee(employee: Employee) {
        employees.removeIf { it.id == employee.id }
    }

    init {
        addEmployee(Employee(
                user = userService.addUser(User(
                        username = "kmartinez",
                        passwordHash = hashService.hash("password"),
                        permissions = listOf()
                )),
                firstName = "Kenn",
                lastName = "Martinez",
                title = "CEO",
                department = "IT",
                salary = 100_000,
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave."
        ))


        addEmployee(Employee(
                user = userService.addUser(User(
                        username = "jacacia",
                        passwordHash = hashService.hash("password"),
                        permissions = listOf()
                )),
                firstName = "Jack",
                lastName = "Acacia",
                title = "Dad",
                department = "Dadology",
                salary = 10_000_000,
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave."
        ))
    }
}