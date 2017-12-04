package swen343.hr.controllers.api.v1.sessions

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.controllers.api.v1.employees.ControllerEmployeesApi
import swen343.hr.controllers.api.v1.employees.ControllerUsersApi
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.SessionService
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.Session
import swen343.hr.models.User
import swen343.hr.util.ApiResponse
import swen343.hr.util.RouteUtil

/**
 * Created by ben on 10/16/17.
 */
class ControllerSessionsApi @Inject constructor(
        private val userService: UserService,
        private val hashProvider: HashProvider,
        private val sessionService: SessionService,
        private val routeUtil: RouteUtil,
        private val employeeService: EmployeeService
) : RouteGroup {

    override fun addRoutes() {
        post("new-session") {
            val username = queryParams("username")
            val password = queryParams("password")

            val passwordHash = hashProvider.hash(password)

            val user = userService.getUser(username)
            if (user?.passwordHash != passwordHash) {
                ApiResponse("Invalid username or password").jsonResponse(response)
            } else {
                val session = sessionService.createSession(user, request.ip())
                ApiResponse(SessionResponse(
                        session,
                        employeeService.getEmployee(session.user.username)
                )).jsonResponse(response)
            }
        }

        get("from-token/:token") {
            val token = params("token")
            val session = sessionService.getSession(token, request.ip())

            if (session == null) {
                ApiResponse("Invalid session token").jsonResponse(response)
            } else {
                ApiResponse(SessionResponse(
                        session,
                        employeeService.getEmployee(session.user.username)
                )).jsonResponse(response)
            }
        }

        get("from-cookie") {
            val token = routeUtil.sessionToken(this)

            if (token == null) {
                ApiResponse("No cookie stored in session").jsonResponse(response)
            } else {
                response.redirect("from-token/$token")
            }
        }
    }

    class SessionResponse(session: Session, employee: Employee?) {
        val token = session.token
        val user = ControllerUsersApi.UserResponse(session.user)
        val employee = employee?.let { ControllerEmployeesApi.EmployeeResponse(employee) }
        val ipAddress = session.ipAddress
        val expiration = session.expiration.toString()
    }
}