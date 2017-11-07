package swen343.hr.controllers.api.v1.employees

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService
import swen343.hr.models.Employee
import swen343.hr.util.ApiResponse

/**
 * Created by ben on 10/16/17.
 */
class ControllerEmployeesApi @Inject constructor(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            ApiResponse(
                    employeeService.getEmployees().map { EmployeeResponse(it) }
            ).jsonResponse(response)
        }

        get("/:username") {
            val username = params("username")
            val employee = employeeService.getEmployee(username)

            if (employee == null) {
                ApiResponse(
                        "Unknown employee: $username"
                ).jsonResponse(response)
            } else {
                ApiResponse(
                        EmployeeResponse(employee)
                ).jsonResponse(response)
            }
        }

        get("/:username/avatar") {
            response.redirect("https://www.rit.edu/gccis/sites/rit.edu.gccis/files/Martinez.jpeg")
        }
    }

    private class EmployeeResponse(employee: Employee) {
        val username = employee.user.username
        val firstName = employee.firstName
        val lastName = employee.lastName
        val title = employee.title
        val department = employee.department
        val salary = employee.salary
        val phoneNumber = employee.phoneNumber
        val email = employee.email
        val address = employee.address
    }
}