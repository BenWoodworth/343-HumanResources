package swen343.hr.controllers.api

import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import swen343.hr.Employee
import swen343.hr.controllers.api.v1.V1Controller

/**
 * Created by ben on 10/16/17.
 */
class ApiController : RouteGroup {

    override fun addRoutes() {
        path("/v1", V1Controller())

        get("employees/:id") {
            val employee: Employee = TODO()

            """
            {
                "employee": {
                    "id": ${employee.id},
                    "salary": ${employee.salary}
                }
            }
            """.trimIndent()
        }
    }
}