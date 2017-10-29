package swen343.hr.controllers.api.v1.employees

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService

/**
 * Created by ben on 10/16/17.
 */
class ControllerEmployeesApi @Inject constructor(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            //TODO
        }

        get("/avatar/:username") {
            response.redirect("https://www.rit.edu/gccis/sites/rit.edu.gccis/files/Martinez.jpeg")
        }
    }
}