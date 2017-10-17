package swen343.hr.controllers.employee

import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader

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

        get("/edit") {
            templateLoader.loadTemplate(
                    "/employees/edit.ftl"


            )
        }

        get("/profile") {
            templateLoader.loadTemplate(
                    "/employees/profile.ftl"


            )
        }
    }
}