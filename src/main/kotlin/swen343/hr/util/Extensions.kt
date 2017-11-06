package swen343.hr.util

import spark.kotlin.RouteHandler
import spark.kotlin.halt
import swen343.hr.models.User

/**
 * Get the user currently logged in.
 */
fun RouteHandler.user(): User? = session().attribute<User>("user")

/**
 * Set the user currently logged in.
 */
fun RouteHandler.user(user: User?) = session().attribute("user", user)

/**
 * Require permissions.
 */
fun RouteHandler.requirePerms(vararg perms: String) {
    val missing = perms
            .filterNot { user()?.hasPermission(it) ?: false }

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