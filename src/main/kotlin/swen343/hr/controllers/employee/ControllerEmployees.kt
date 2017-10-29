package swen343.hr.controllers.employee

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.Employee
import swen343.hr.viewmodels.ViewModelEmployee

/**
 * Created by ben on 10/16/17.
 */
class ControllerEmployees @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            templateLoader.loadTemplate(
                    "/employees/view-all.ftl"

            )
        }

        get("/add") {
            templateLoader.loadTemplate(
                    "/employees/add.ftl"

            )
        }

        post("/add") {
            val employee = Employee(
                    username = request.queryParams("username"),
                    firstName = request.queryParams("firstName"),
                    lastName = request.queryParams("lastName"),
                    title = request.queryParams("title"),
                    department = request.queryParams("department"),
//                    salary = request.queryParams("salary").toInt(),
                    salary = request.queryParams("salary"),
                    phoneNumber = request.queryParams("phoneNumber"),
                    email = request.queryParams("email"),
                    address = request.queryParams("address"),
                    picture = request.queryParams("picture")
            )
            employeeService.updateEmployee(employee)
            response.redirect("/employees/profile/${employee.username}")
        }

        get("/edit/:username") {
            val username = request.params("username")
            val employee = employeeService.getEmployee(username)
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        ViewModelEmployee(employee)
                )
            } else {

            }
        }

        get("/delete/:username") {
            val username = request.params("username")
            if (username != null) {
                employeeService.deleteEmployee(username)
            }
            response.redirect("/")

        }

        post("/edit/submit") {
            val employee = Employee(
                    username = request.queryParams("username"),
                    firstName = request.queryParams("firstName"),
                    lastName = request.queryParams("lastName"),
                    title = request.queryParams("title"),
                    department = request.queryParams("department"),
//                    salary = request.queryParams("salary").replace(",", "").toInt(),
                    salary = request.queryParams("salary"),
                    phoneNumber = request.queryParams("phoneNumber"),
                    email = request.queryParams("email"),
                    address = request.queryParams("address"),
                    picture = request.queryParams("picture")
            )
            employeeService.updateEmployee(employee)
            response.redirect("/employees/profile/${employee.username}")
        }

        get("/profile/:username") {
            val username = request.params("username")
            val employee = employeeService.getEmployee(username)

            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/profile.ftl",
                        ViewModelEmployee(employee)

                )
            } else {
                // TODO (Error page)
            }
        }
    }
}