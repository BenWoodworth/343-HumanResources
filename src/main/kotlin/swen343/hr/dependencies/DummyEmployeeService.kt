package swen343.hr.dependencies

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class DummyEmployeeService : EmployeeService {

    private val employees = mutableListOf<Employee>()

    init {
        addEmployee(Employee(
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

        addEmployee(Employee(
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

        addEmployee(Employee(
                id = 2,
                firstName = "John",
                lastName = "Ahn",
                title = "Professional Memer",
                department = "HR",
                salary = 0,
                phoneNumber = "5555555556",
                email = "jka1284@example.com",
                address = "123 Meme."
        ))
        addEmployee(Employee(
                id = 3,
                firstName = "Ben",
                lastName = "Woodworth",
                title = "Development",
                department = "HR",
                salary = 80_020,
                phoneNumber = "5555555558",
                email = "benwoodworth@ben.woodworth",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 4,
                firstName = "Dan",
                lastName = "Swootmin",
                title = "Senior Citizen",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555559",
                email = "DadSweetmin@Sweemin.cam",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 5,
                firstName = "Beltran",
                lastName = "Caliz",
                title = "Team Dad",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555560",
                email = "Beltrin@Beltrain.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 6,
                firstName = "Sammi",
                lastName = "Bun",
                title = "Civie",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "ech@ech.com",
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