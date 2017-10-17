package swen343.hr.controllers.employee

import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.IndexViewModel

/**
 * Created by ben on 10/16/17.
 */
class EmployeeController(
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {
        /*
        get("/add") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    IndexViewModel(request.ip())
            )
        }

        get("/edit") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    IndexViewModel(request.ip())
            )
        }
        */
    }
}