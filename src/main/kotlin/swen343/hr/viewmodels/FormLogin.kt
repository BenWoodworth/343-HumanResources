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
        override val fields: FormLogin.Fields
) : Form<FormLogin.Fields>({
    val user = userService.getUser(fields.username)
    val passwordHash = hashProvider.hash(fields.password)

    when {
        fields.username.isEmpty() ->
             errors += "Username missing"
        fields.password.isEmpty() ->
            errors += "Password missing"
        user?.passwordHash != passwordHash ->
            errors += "Incorrect username or password"
    }
}) {

    data class Fields(
            val username: String,
            val password: String
    )

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
                    fields = FormLogin.Fields(
                            username = username,
                            password = password
                    )
            )
        }
    }
}