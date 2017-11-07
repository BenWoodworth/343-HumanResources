package swen343.hr.controllers.api.v1.employees

import com.google.inject.Inject
import spark.Response
import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.ApiResponse
import swen343.hr.util.Permission

/**
 * Created by ben on 10/16/17.
 */
class ControllerUsersApi @Inject constructor(
        private val userService: UserService
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            ApiResponse(
                    userService.getUsers().map { UserResponse(it) }
            ).jsonResponse(response)
        }

        get("/:username") {
            val username = request.params("username")
            val user = userService.getUser(username)

            if (user == null) {
                ApiResponse(
                        "User not found: $username"
                ).jsonResponse(response)
            } else {
                ApiResponse(UserResponse(user)).jsonResponse(response)
            }
        }

        get("/:username/has-perm/:permission") {
            val username = request.params("username")
            val user = userService.getUser(username)

            val permission = request.params("permission")

            if (user == null) {
                ApiResponse(
                        "User not found: $username"
                ).jsonResponse(response)
            } else {
                ApiResponse(object {
                    val hasPermission = user.hasPermission(permission)
                }).jsonResponse(response)
            }
        }
    }

    private class UserResponse(user: User) {
        val username = user.username
        val permissions = user.permissions.map { it.toString() }
    }
}