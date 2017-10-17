package swen343.hr.controllers.api

import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.models.Employee
import swen343.hr.controllers.api.v1.V1Controller
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
class ApiController(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        path("/v1", V1Controller(employeeService))
    }
}