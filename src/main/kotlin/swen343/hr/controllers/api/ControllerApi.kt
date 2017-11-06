package swen343.hr.controllers.api

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import swen343.hr.controllers.api.v1.ControllerV1
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class ControllerApi @Inject constructor(
        private val controllerApiV1: ControllerV1
) : RouteGroup {

    override fun addRoutes() {
        path("/v1", controllerApiV1)
    }
}