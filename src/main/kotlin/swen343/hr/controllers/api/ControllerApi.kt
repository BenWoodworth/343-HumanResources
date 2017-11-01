package swen343.hr.controllers.api

import spark.RouteGroup
import spark.Spark.path
import swen343.hr.controllers.api.v1.ControllerV1
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
class ControllerApi(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        path("/v1", ControllerV1(employeeService))
    }
}