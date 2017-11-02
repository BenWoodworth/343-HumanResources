package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.Spark.path
import spark.kotlin.port
import spark.kotlin.staticFiles
import swen343.hr.controllers.ControllerIndex

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class WebFrameworkSpark @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService,
        private val hrProperties: Config
) : WebFramework {

    override fun initialize() {
        port(hrProperties.port)

        staticFiles.location("/public")

        path("/", ControllerIndex(templateLoader, employeeService))
    }
}