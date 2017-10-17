package swen343.hr.dependencies

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class DummyEmployeeService : EmployeeService {

    private val employees = mutableListOf<Employee>()

    override fun getEmployees() = employees.toList()

    override fun getEmployee(id: Int) = employees.firstOrNull { it.id == id }

    override fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    override fun editEmployee(employee: Employee) = addEmployee(employee)

    override fun deleteEmployee(id: Int) {
        employees.removeIf {
            it.id == id
        }
    }

    init {
        addEmployee(Employee(
                id = 0,
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
        addEmployee(Employee(
                id = 7,
                firstName = "Jack",
                lastName = "Acacia",
                title = "Arty. Officer",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 8,
                firstName = "John",
                lastName = "Lennon",
                title = "Legendary Guitar-man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 9,
                firstName = "Bruce",
                lastName = "Wayne",
                title = "Batmin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 10,
                firstName = "Jonathan",
                lastName = "Dang",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 11,
                firstName = "Gordon",
                lastName = "Freedude",
                title = "Crowbar enthuisast",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 12,
                firstName = "Donald",
                lastName = "Troomp",
                title = "Cheeto Man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 13,
                firstName = "Clark",
                lastName = "Kant",
                title = "Not Supermin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 14,
                firstName = "Bojack",
                lastName = "Horseman",
                title = "Depressed",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 15,
                firstName = "Martin",
                lastName = "Walker",
                title = "Dead Man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 16,
                firstName = "James",
                lastName = "Gordin",
                title = "Detective man",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 17,
                firstName = "Frank",
                lastName = "Castle",
                title = "The Discipliner",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 18,
                firstName = "Chris",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 19,
                firstName = "Solid",
                lastName = "Snake",
                title = "Philantrophist",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 20,
                firstName = "Big",
                lastName = "Boss",
                title = "Big Dad",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 21,
                firstName = "Ruby",
                lastName = "Rose",
                title = "Reaper",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 22,
                firstName = "Ben",
                lastName = "Doo",
                title = "Hoomin",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 23,
                firstName = "Charlie",
                lastName = "November",
                title = "CN",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 24,
                firstName = "Victor",
                lastName = "Zulu",
                title = "VZ",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
        addEmployee(Employee(
                id = 25,
                firstName = "Juliet",
                lastName = "Papa",
                title = "JP",
                department = "HR",
                salary = 80_000,
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave."
        ))
    }
}