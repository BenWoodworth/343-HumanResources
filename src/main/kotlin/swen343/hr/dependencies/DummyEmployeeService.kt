package swen343.hr.dependencies

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class DummyEmployeeService : EmployeeService {

    private val employees = mutableListOf<Employee>()

    init {
        employees.add(Employee(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                title = "Project Manager",
                department = "IT",
                salary = 100_000,
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave."
        ))

        employees.add(Employee(
                id = 1,
                firstName = "Jane",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
    }

    override fun getEmployees() = employees.toList()

    override fun getEmployee(id: Int) = employees.firstOrNull { it.id == id }

    override fun addEmployee(employee: Employee) {
        deleteEmployee(employee)
        employees.add(employee)
    }

    override fun editEmployee(employee: Employee) = addEmployee(employee)

    override fun deleteEmployee(employee: Employee) {
        employees.removeIf {
            it.id == employee.id
        }
    }
}