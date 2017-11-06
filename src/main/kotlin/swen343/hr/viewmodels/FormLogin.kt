package swen343.hr.viewmodels

import com.google.inject.Inject
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.UserService
import swen343.hr.models.User

/**
 * Created by ben on 11/6/17.
 */
class FormLogin(
        userService: UserService,
        hashProvider: HashProvider,

        override val sessionUser: User?,

        val username: String?,
        val password: String?
) : Form({
    val user = username?.let { userService.getUser(username) }
    val passwordHash = password?.let { hashProvider.hash(password) }

    when {
        username.isNullOrEmpty() ->
            "Username missing"
        password.isNullOrEmpty() ->
            "Password missing"
        user?.passwordHash != passwordHash ->
            "Incorrect username or password"
        else -> null
    }
}) {

    class Factory @Inject constructor(
            private val userService: UserService,
            private val hashProvider: HashProvider
    ) {
        fun getForm(
                sessionUser: User?,
                username: String = "",
                password: String = ""
        ): FormLogin {
            return FormLogin(
                    userService = userService,
                    hashProvider = hashProvider,
                    sessionUser = sessionUser,
                    username = username,
                    password = password
            )
        }
    }
}