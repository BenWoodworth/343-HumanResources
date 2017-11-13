package swen343.hr

import com.google.inject.Inject
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.UserService
import swen343.hr.dependencies.WebFramework
import swen343.hr.models.User
import swen343.hr.util.Permission
import kotlin.system.exitProcess

/**
 * Created by ben on 10/16/17.
 */
class HumanResources @Inject constructor(
        private val webFramework: WebFramework,
        private val userService: UserService,
        private val hashProvider: HashProvider
) {

    fun start(args: Array<String>) {
        if (args.contains("--reset-admin")) {
            resetAdmin()
            exitProcess(0)
        } else {
            setupAdmin()
        }

        webFramework.initialize()
    }

    private fun resetAdmin() {
        val rand = (Math.random() * 900 + 100).toInt().toString()
        val password = "password$rand"

        val user = userService.getUser("admin")!!
        userService.editUser(user.copy(
                username = "admin",
                passwordHash = hashProvider.hash(password),
                permissions = listOf(Permission("*"))
        ))

        println("Admin account setup.")
        println("user: admin")
        println("pass: $password")
    }

    private fun setupAdmin() {
        if (userService.getUser("admin") != null) return

        userService.addUser(User(
                username = "admin",
                passwordHash = "",
                permissions = emptyList()
        ))

        resetAdmin()
    }
}