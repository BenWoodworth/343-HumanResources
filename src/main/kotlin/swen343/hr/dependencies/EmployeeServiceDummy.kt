package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class EmployeeServiceDummy : EmployeeService {

    private val employees = mutableListOf<Employee>()

    override fun getEmployees() = employees.toList()

    override fun getEmployee(username: String): Employee? {
        return employees.firstOrNull {
            it.username == username
        }
    }

    override fun updateEmployee(employee: Employee) {
        deleteEmployee(employee.username)
        employees.add(employee)
    }

    override fun deleteEmployee(username: String) {
        employees.removeIf {
            it.username == username
        }
    }

    init {
        updateEmployee(Employee(
                username = "kmartinez",
                firstName = "Kenn",
                lastName = "Martinez",
                title = "CEO",
                department = "IT",
                salary = "100,000",
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave.",
        ))

        updateEmployee(Employee(
                username = "janedoe",
                firstName = "Jane",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = "80_000",
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave.",
        ))

        updateEmployee(Employee(
                username = "jahn",
                firstName = "John",
                lastName = "Ahn",
                title = "Professional Memer",
                department = "HR",
                salary = "0",
                phoneNumber = "5555555556",
                email = "jka1284@example.com",
                address = "123 Meme.",
        ))
        
        updateEmployee(Employee(
                username = "ban",
                firstName = "Ben",
                lastName = "Woodworth",
                title = "Development",
                department = "HR",
                salary = "80_020",
                phoneNumber = "5555555558",
                email = "benwoodworth@ben.woodworth",
                address = "123 Fake Ave.",
        ))
        
        updateEmployee(Employee(
                username = "dswootman",
                firstName = "Dan",
                lastName = "Swootmin",
                title = "Senior Citizen",
                department = "HR",
                salary = "80_000",
                phoneNumber = "5555555559",
                email = "DadSweetmin@Sweemin.cam",
                address = "123 Fake Ave.",
        ))
    }
}