package swen343.hr.controllers

import com.google.inject.Inject
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employee.ControllerEmployees
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.ViewModelIndex

class ControllerIndex @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        path("/api", ControllerApi(employeeService))

        path("/employees", ControllerEmployees(templateLoader, employeeService))

        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    ViewModelIndex(request.ip(), employeeService.getEmployees())
            )
        }
    }
}