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
                username = "",
                firstName = "Kenn",
                lastName = "Martinez",
                title = "CEO",
                department = "IT",
                salary = "100,000",
                phoneNumber = "5555555555",
                email = "john_doe@example.com",
                address = "123 Fake Ave.",
                picture = "https://www.rit.edu/gccis//sites/rit.edu.gccis/files//Martinez.jpeg"
        ))

        updateEmployee(Employee(
                username = "",
                firstName = "Jane",
                lastName = "Doe",
                title = "Sales Rep",
                department = "HR",
                salary = "80_000",
                phoneNumber = "5555555554",
                email = "jane_doe@example.com",
                address = "123 Fake Ave.",
                picture = "https://thumb1.shutterstock.com/display_pic_with_logo/3038285/538707310/stock-vector-empty-photo-of-male-profile-gray-person-picture-isolated-on-white-background-good-unknown-empty-538707310.jpg"
        ))

        updateEmployee(Employee(
                username = "",
                firstName = "John",
                lastName = "Ahn",
                title = "Professional Memer",
                department = "HR",
                salary = "0",
                phoneNumber = "5555555556",
                email = "jka1284@example.com",
                address = "123 Meme.",
                picture = "https://thumb1.shutterstock.com/display_pic_with_logo/3038285/538707310/stock-vector-empty-photo-of-male-profile-gray-person-picture-isolated-on-white-background-good-unknown-empty-538707310.jpg"
        ))
        
        updateEmployee(Employee(
                username = "",
                firstName = "Ben",
                lastName = "Woodworth",
                title = "Development",
                department = "HR",
                salary = "80_020",
                phoneNumber = "5555555558",
                email = "benwoodworth@ben.woodworth",
                address = "123 Fake Ave.",
                picture = "https://thumb1.shutterstock.com/display_pic_with_logo/3038285/538707310/stock-vector-empty-photo-of-male-profile-gray-person-picture-isolated-on-white-background-good-unknown-empty-538707310.jpg"
        ))
        
        updateEmployee(Employee(
                username = "",
                firstName = "Dan",
                lastName = "Swootmin",
                title = "Senior Citizen",
                department = "HR",
                salary = "80_000",
                phoneNumber = "5555555559",
                email = "DadSweetmin@Sweemin.cam",
                address = "123 Fake Ave.",
                picture = "https://thumb1.shutterstock.com/display_pic_with_logo/3038285/538707310/stock-vector-empty-photo-of-male-profile-gray-person-picture-isolated-on-white-background-good-unknown-empty-538707310.jpg"
        ))
    }
}