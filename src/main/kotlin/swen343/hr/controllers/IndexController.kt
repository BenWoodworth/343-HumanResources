package swen343.hr.controllers

import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import spark.kotlin.staticFiles
import swen343.hr.controllers.api.ApiController
import swen343.hr.controllers.employee.EmployeesController
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.IndexViewModel

class IndexController(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        path("/api", ApiController(employeeService))

        path("/employees", EmployeesController(templateLoader, employeeService))

        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    IndexViewModel(request.ip(), employeeService.getEmployees())
            )
        }
    }
}