package swen343.hr.controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employee.ControllerEmployees
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.ViewModelIndex

@Singleton
class ControllerIndex @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService,
        private val controllerApi: ControllerApi,
        private val controllerEmployees: ControllerEmployees
) : RouteGroup {

    override fun addRoutes() {
        path("/api", controllerApi)

        path("/employees", controllerEmployees)

        get("/register") {
            templateLoader.loadTemplate(
                    "register.ftl",
                    null
            )
        }
        get("/router") {
            templateLoader.loadTemplate(
                    "router.ftl",
                    null
            )
        }
        get("/home") {
            templateLoader.loadTemplate(
                    "home.ftl",
                    ViewModelIndex(request.ip(), employeeService.getEmployees())
            )
        }
        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    null
            )
        }
    }
}