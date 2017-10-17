package swen343.hr.controllers.employee

import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.TemplateLoader

/**
 * Created by ben on 10/16/17.
 */
class EmployeeController(
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {



        get("/add") {
            templateLoader.loadTemplate(
                    "/employee/add.ftl"

            )
        }

        get("/edit") {
            templateLoader.loadTemplate(
                    "/employee/edit.ftl"


            )
        }

        get("/profile") {
            templateLoader.loadTemplate(
                    "/employee/profile.ftl"


            )
        }

        get("/") {
            templateLoader.loadTemplate(
                    "/employee/view-all.ftl"


            )
        }

    }
}