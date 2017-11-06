package swen343.hr.viewmodels

import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.UserService
import swen343.hr.models.User

/**
 * Created by ben on 11/6/17.
 */
class FormLogin(
        userService: UserService,
        hashProvider: HashProvider,

        override val sessionUser: User,

        val username: String = "",
        val password: String = ""
) : Form({
    val user = userService.getUser(username)
    val passwordHash = hashProvider.hash(password)

    if (user?.passwordHash != passwordHash) {
        "Incorrect username or password"
    } else {
        null
    }
})