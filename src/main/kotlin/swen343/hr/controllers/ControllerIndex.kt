package swen343.hr.controllers

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.controllers.api.ControllerApi
import swen343.hr.controllers.employees.ControllerEmployees
import swen343.hr.controllers.auth.ControllerAuth
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.User
import swen343.hr.util.user
import swen343.hr.viewmodels.ViewModelBasic

@Singleton
class ControllerIndex @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val controllerApi: ControllerApi,
        private val controllerEmployees: ControllerEmployees,
        private val controllerAuth: ControllerAuth
) : RouteGroup {

    override fun addRoutes() {
        path("/api", controllerApi)

        path("/employees", controllerEmployees)

        path("/auth", controllerAuth)

        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    ViewModelBasic(session().user())
            )
        }

        get("/silos") {
            templateLoader.loadTemplate(
                    "silos.ftl",
                    ViewModelBasic(session().user())
            )
        }

        get("/router") {
            templateLoader.loadTemplate(
                    "silos.ftl",
                    ViewModelBasic(session().user())
            )
        }
    }
}