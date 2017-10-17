package swen343.hr.controllers.api.v1

import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService
import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class V1Controller(
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {

        get("/employees/:id") {
            val id = request.params("id").toIntOrNull()
            val employee = id?.let { employeeService.getEmployee(id) }

            if (employee == null) {
                """
                {
                    "employee": null
                }
                """.trimIndent()
            } else {
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
}