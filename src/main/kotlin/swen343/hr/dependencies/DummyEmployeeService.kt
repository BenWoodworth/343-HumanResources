package swen343.hr.dependencies

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class DummyEmployeeService : EmployeeService {

    private val employees = mutableListOf<Employee>()

    override fun getEmployees() = employees.toList()

    override fun getEmployee(id: Int) = employees.firstOrNull { it.id == id }

    override fun addEmployee(
            firstName: String,
            lastName: String,
            title: String,
            department: String,
            salary: Int,
            phoneNumber: String,
            email: String,
            address: String
    ): Employee {
        val maxId = employees
                .map { it.id }
                .max() ?: -1

        val employee = Employee(
                id = maxId + 1,
                firstName = firstName,
                lastName = lastName,
                title = title,
                department = department,
                salary = salary,
                phoneNumber = phoneNumber,
                email = email,
                address = address
        )

        employees.add(employee)

        return employee
    }



    override fun editEmployee(employee: Employee) {
        deleteEmployee(employee.id)
        employees.add(employee)
    }

    override fun deleteEmployee(id: Int) {
        employees.removeIf {
            it.id == id
        }
    }

    init {
        addEmployee(
                firstName = "Kenn",
                lastName = "Martinez",
                title = "CEO",
                department = "IT",
                salary = 100_000,
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave."
        )

        addEmployee(
                firstName = "Jane",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )

        addEmployee(
                firstName = "John",
                lastName = "Ahn",
                title = "Professional Memer",
                department = "HR",
                salary = 0,
                phoneNumber = "5555555556",
                email = "jka1284@example.com",
                address = "123 Meme."
        )
        addEmployee(
                firstName = "Ben",
                lastName = "Woodworth",
                title = "Development",
                department = "HR",
                salary = 80_020,
                phoneNumber = "5555555558",
                email = "benwoodworth@ben.woodworth",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Dan",
                lastName = "Swootmin",
                title = "Senior Citizen",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555559",
                email = "DadSweetmin@Sweemin.cam",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Beltran",
                lastName = "Caliz",
                title = "Team Dad",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555560",
                email = "Beltrin@Beltrain.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Sammi",
                lastName = "Bun",
                title = "Civie",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "ech@ech.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Jack",
                lastName = "Acacia",
                title = "Arty. Officer",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "John",
                lastName = "Lennon",
                title = "Legendary Guitar-man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Bruce",
                lastName = "Wayne",
                title = "Batmin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Jonathan",
                lastName = "Dang",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Gordon",
                lastName = "Freedude",
                title = "Crowbar enthuisast",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Donald",
                lastName = "Troomp",
                title = "Cheeto Man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Clark",
                lastName = "Kant",
                title = "Not Supermin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Bojack",
                lastName = "Horseman",
                title = "Depressed",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Martin",
                lastName = "Walker",
                title = "Dead Man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "James",
                lastName = "Gordin",
                title = "Detective man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Frank",
                lastName = "Castle",
                title = "The Discipliner",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Chris",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Solid",
                lastName = "Snake",
                title = "Philantrophist",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Big",
                lastName = "Boss",
                title = "Big Dad",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Ruby",
                lastName = "Rose",
                title = "Reaper",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Ben",
                lastName = "Doo",
                title = "Hoomin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Charlie",
                lastName = "November",
                title = "CN",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Victor",
                lastName = "Zulu",
                title = "VZ",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
        addEmployee(
                firstName = "Juliet",
                lastName = "Papa",
                title = "JP",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        )
    }
}