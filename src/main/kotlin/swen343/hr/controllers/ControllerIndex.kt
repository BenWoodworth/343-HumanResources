package swen343.hr.controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employees.ControllerEmployees
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader

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

        get("/silos") {
            templateLoader.loadTemplate(
                    "silos.ftl",
                    null
            )
        }

        get("/router") {
            templateLoader.loadTemplate(
                    "silos.ftl",
                    null
            )
        }

        get("/") {
            templateLoader.loadTemplate(
                    "login.ftl",
                    null
            )
        }
    }
}