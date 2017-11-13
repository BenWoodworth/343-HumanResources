package swen343.hr.controllers.api.v1.employees

import com.google.inject.Inject
import spark.Response
import spark.RouteGroup
import spark.kotlin.get
import swen343.hr.Permissions
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.ApiResponse
import swen343.hr.util.Permission
import swen343.hr.util.RouteUtil

/**
 * Created by ben on 10/16/17.
 */
class ControllerUsersApi @Inject constructor(
        private val userService: UserService,
        private val routeUtil: RouteUtil
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            routeUtil.requirePermsApi(this, Permissions.HR_API_USERS)
            ApiResponse(
                    userService.getUsers().map { UserResponse(it) }
            ).jsonResponse(response)
        }

        get("/:username") {
            routeUtil.requirePermsApi(this, Permissions.HR_API_USERS)
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
            routeUtil.requirePermsApi(this, Permissions.HR_API_USERS_PERMISSION)
            val username = request.params("username")
            val user = userService.getUser(username)

            val permission = request.params("permission")

            if (user == null) {
                ApiResponse(
                        "User not found: $username"
                ).jsonResponse(response)
            } else {
                val hasPermission = user.hasPermission(permission)
                ApiResponse(PermissionResponse(hasPermission)).jsonResponse(response)
            }
        }
    }

    class UserResponse(user: User) {
        val username = user.username
        val permissions = user.permissions.map { it.toString() }
    }

    class PermissionResponse(
            val hasPermission: Boolean
    )
}