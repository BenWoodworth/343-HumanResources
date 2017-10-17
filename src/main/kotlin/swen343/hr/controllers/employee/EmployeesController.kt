package swen343.hr.controllers.employee

import spark.RouteGroup
import spark.kotlin.delete
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.EmployeeViewModel

/**
 * Created by ben on 10/16/17.
 */
class EmployeesController(
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
            if (employee!=null){
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        EmployeeViewModel(employee)

                )
            }
            else {

            }
        }

        get("/employees/delete/:id") {
            val id = request.params("id").toIntOrNull()
            if (id!=null) {
                employeeService.deleteEmployee(id)
            }
            response.redirect("/")

        }

        get("/profile/:id") {
            val id = request.params("id").toIntOrNull()
            val employee = id?.let { employeeService.getEmployee(id) }
            if (employee!=null){
                templateLoader.loadTemplate(
                        "/employees/profile.ftl",
                        EmployeeViewModel(employee)

                )
            }
            else {

            }

        }
    }
}