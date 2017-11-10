package swen343.hr.util

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.kotlin.RouteHandler
import spark.kotlin.halt
import swen343.hr.dependencies.SessionService
import swen343.hr.dependencies.UserService
import swen343.hr.models.User

/**
 * Created by ben on 11/6/17.
 */
@Singleton
class RouteUtil @Inject constructor(
        private val sessionService: SessionService
) {

    /**
     * Get the user currently logged in.
     */
    fun user(routeHandler: RouteHandler): User? {
        return routeHandler.request.cookie("SID")?.let {
            sessionService.getSession(it)?.user
        }
    }

    /**
     * Set the user currently logged in.
     */
    fun user(routeHandler: RouteHandler, user: User?) {
        routeHandler.request.cookie("SID")?.let {
            sessionService.endSession(it)
        }

        user?.let {
            val session = sessionService.createSession(it)
            routeHandler.response.cookie(
                    ".kennuware.com",
                    null,
                    "SID",
                    session.sessionId,
                    -1,
                    false,
                    false
            )
        }
    }

    /**
     * Set the user currently logged in.
     */
    fun requirePerms(routeHandler: RouteHandler, vararg perms: String) {
        val user = user(routeHandler)
        val missing = perms.filterNot { user?.hasPermission(it) ?: false }

        if (missing.isEmpty()) return

        halt(403,
                """
                <b>You do not have permission to access this page.</b><br>
                Please contact your admin if you believe this is a mistake.<br>
                <br>
                <b>Required permissions:</b><br>
                ${perms.joinToString("<br>")}<br>
                <br>
                <b>Missing permissions:</b><br>
                ${missing.joinToString("<br>")}
            """.trimIndent()
        )
    }

    /**
     * Require permissions to use an API.
     */
    fun requirePermsApi(routeHandler: RouteHandler, vararg perms: String) {
        val user = user(routeHandler)
        val missing = perms.filterNot { user?.hasPermission(it) ?: false }

        if (missing.isEmpty()) return

        val apiResponse = ApiResponse("Missing permissions: ${missing.joinToString(", ")}")
        val json = apiResponse.jsonResponse(routeHandler.response)

        halt(403, json)
    }
}