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

        get("/employee-info") {
            templateLoader.loadTemplate(
                    "employee-info.ftl",
                    IndexViewModel(request.ip())
            )
        }

        get("/create-employee") {
            templateLoader.loadTemplate(
                    "create-employee.ftl",
                    IndexViewModel(request.ip())
            )
        }

    }
}