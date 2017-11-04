package swen343.hr.controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employees.ControllerEmployees
import swen343.hr.controllers.login.ControllerLogin
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.User

@Singleton
class ControllerIndex @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val controllerApi: ControllerApi,
        private val controllerEmployees: ControllerEmployees,
        private val controllerLogin: ControllerLogin
) : RouteGroup {

    override fun addRoutes() {
        path("/api", controllerApi)

        path("/employees", controllerEmployees)

        path("/login", controllerLogin)

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
            val user = session().attribute<User?>("user")

            if (user == null) {
                """
                    You are not logged in!<br>
                    Please <a href="/login">login</a>.
                """
            } else {
                "Welcome back, ${user.username}!"
            }
        }
    }
}