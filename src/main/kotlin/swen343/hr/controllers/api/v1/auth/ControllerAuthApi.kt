package swen343.hr.controllers.api.v1.auth

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.post
import swen343.hr.controllers.api.v1.employees.ControllerUsersApi
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.SessionService
import swen343.hr.dependencies.UserService
import swen343.hr.models.Session
import swen343.hr.util.ApiResponse
import java.util.*

class ControllerAuthApi @Inject constructor(
        private val userService: UserService,
        private val hashProvider: HashProvider,
        private val sessionService: SessionService
) : RouteGroup

{
    override fun addRoutes() {
        post("/new-session") {
            val username = queryParams("username")
            val password = queryParams("password")

            val passwordHash = hashProvider.hash(password)

            val user = userService.getUser(username)
            if (user?.passwordHash != passwordHash) {
                ApiResponse("Invalid username or password").jsonResponse(response)
            }

            val session = sessionService.createSession(user!!, request.ip())
            ApiResponse(SessionResponse(session)).jsonResponse(response)
        }
    }

    class SessionResponse(session: Session) {
        val token = session.token
        val ipAddress = session.ipAddress
        val expiration = session.expiration.toString()
    }
}