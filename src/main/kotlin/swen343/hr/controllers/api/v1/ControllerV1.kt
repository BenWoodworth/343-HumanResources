package swen343.hr.controllers.api.v1

import com.google.inject.Inject
import spark.RouteGroup
import spark.Spark.path
import swen343.hr.controllers.api.v1.employees.ControllerEmployeesApi
import swen343.hr.controllers.api.v1.employees.ControllerUsersApi
import swen343.hr.controllers.api.v1.sessions.ControllerSessionsApi

/**
 * Created by ben on 10/16/17.
 */
class ControllerV1 @Inject constructor(
        private val controllerEmployeesApi: ControllerEmployeesApi,
        private val controllerUsersApi: ControllerUsersApi,
        private val controllerSessionsApi: ControllerSessionsApi
) : RouteGroup {

    override fun addRoutes() {
        path("/employees", controllerEmployeesApi)
        path("/users", controllerUsersApi)
        path("/sessions", controllerSessionsApi)
    }
}