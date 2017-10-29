package swen343.hr.controllers.api.v1

import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
class V1Controller(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {

        get("/employees") {

        }
    }
}