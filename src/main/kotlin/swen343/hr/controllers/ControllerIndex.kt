package swen343.hr.controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employees.ControllerEmployees
import swen343.hr.controllers.users.ControllerUsers
import swen343.hr.controllers.auth.ControllerAuth
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.util.user
import swen343.hr.viewmodels.ViewModelBasic

@Singleton
class ControllerIndex @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val controllerApi: ControllerApi,
        private val controllerEmployees: ControllerEmployees,
        private val controllerUsers: ControllerUsers,
        private val controllerAuth: ControllerAuth
) : RouteGroup {

    override fun addRoutes() {
        path("/api", controllerApi)

        path("/employees", controllerEmployees)

        path("/users", controllerUsers)

        path("/auth", controllerAuth)

        get("/") {
            if (user() == null) {
                response.redirect("/auth/login")
            } else {
                templateLoader.loadTemplate(
                        "index.ftl",
                        ViewModelBasic(user())
                )
            }
        }

        get("/silos") {
            templateLoader.loadTemplate(
                    "silos.ftl",
                    ViewModelBasic(user())
            )
        }
    }
}