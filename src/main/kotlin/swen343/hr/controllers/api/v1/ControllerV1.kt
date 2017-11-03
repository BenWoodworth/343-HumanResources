package swen343.hr.controllers.api.v1

import spark.RouteGroup
import spark.Spark
import swen343.hr.controllers.api.v1.employees.ControllerEmployeesApi
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
class ControllerV1(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        Spark.path("/employees", ControllerEmployeesApi(employeeService))
        Spark.path("/totalBudget", ControllerEmployeesApi(employeeService))
    }

}