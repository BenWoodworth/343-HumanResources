package swen343.hr.dependencies

import com.google.inject.Inject
import spark.Spark.path
import spark.kotlin.port
import spark.kotlin.staticFiles
import swen343.hr.controllers.IndexController

/**
 * Created by ben on 10/16/17.
 */
class WebFrameworkSpark @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService
) : WebFramework {

    override fun initialize() {
        port(1234)

        staticFiles.location("/public")

        path("", IndexController(templateLoader, employeeService))
    }
}