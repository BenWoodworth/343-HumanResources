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

        get("/edit/:id") {
            val id = request.params("id").toIntOrNull()
            val employee = id?.let { employeeService.getEmployee(id) }
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        ViewModelEmployee(employee)

                )
            } else {

            }
        }

        get("/delete/:id") {
            val id = request.params("id").toIntOrNull()
            if (id != null) {
                employeeService.deleteEmployee(id)
            }
            response.redirect("/")

        }

        post("/add") {
            val employee = employeeService.addEmployee(
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
            response.redirect("/employees/profile/${employee.id}")
        }

        post("/edit/submit") {
            val employee = Employee(
                    id = request.queryParams("id").toInt(),
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
            employeeService.editEmployee(employee)
            response.redirect("/employees/profile/${employee.id}")
        }

        get("/profile/:id") {
            val id = request.params("id").toIntOrNull()
            val employee = id?.let { employeeService.getEmployee(id) }
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/profile.ftl",
                        ViewModelEmployee(employee)

                )
            } else {

            }

        }
    }
}