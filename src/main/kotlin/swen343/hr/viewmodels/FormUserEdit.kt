package swen343.hr.viewmodels

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.dependencies.UserService
import swen343.hr.models.User
import swen343.hr.util.Permission

/**
 * Created by ben on 11/6/17.
 */
class FormUserEdit(
        private val userService: UserService,

        override val sessionUser: User?,
        override val fields: FormUserEdit.Fields,

        val user: User
) : Form<FormUserEdit.Fields>({
    val usernameUser = userService.getUser(fields.username)
    if  (usernameUser != null && usernameUser.id != user.id) {
        errors += "The username already in use"
    }

    if (fields.newPassword != fields.newPasswordConfirm) {
        errors += "The passwords don't match"
    }

    val permissions = fields.permissions.split(Regex("\\v"))
    for (permission in permissions) {
        try {
            Permission(permission)
        } catch (exception: Exception) {
            errors += "Invalid permission: \"$permission\""
        }
    }
}) {

    class Fields(
            val username: String = "",
            val newPassword: String = "",
            val newPasswordConfirm: String = "",
            val permissions: String = ""
    ) {
        constructor(user: User) : this(
                username = user.username,
                newPassword = "",
                newPasswordConfirm = "",
                permissions = user.permissions.joinToString("<br/>")
        )
    }

    @Singleton
    class Factory @Inject constructor(
            private val userService: UserService
    ) {
        fun getForm(
                sessionUser: User?,
                fields: FormUserEdit.Fields,
                user: User
        ) = FormUserEdit(
                userService = userService,
                sessionUser = sessionUser,
                fields = fields,
                user = user
        )
    }
}