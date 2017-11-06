package swen343.hr.controllers.users

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.UserService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.User
import swen343.hr.util.Permission
import swen343.hr.util.user
import swen343.hr.viewmodels.ViewModelBasic
import swen343.hr.viewmodels.ViewModelUser
import swen343.hr.viewmodels.ViewModelUserList

/**
 * Created by beltran on 11/05/17.
 */
@Singleton
class ControllerUsers @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val userService: UserService,
        private val hashProvider: HashProvider
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            templateLoader.loadTemplate(
                    "/users/users.ftl",
                    ViewModelUserList(
                            user(),
                            userService
                                    .getUsers()
                                    .sortedBy { it.username.toLowerCase() }
                    )
            )
        }

        get("/add") {
            templateLoader.loadTemplate(
                    "/users/add.ftl",
                    ViewModelBasic(user())
            )
        }

        post("/add") {
            val permissions = request
                    .queryParams("permissions")
                    .split(Regex("\\v+"))
                    .map { Permission(it) }

            val user = userService.addUser(User(
                    username = request.queryParams("username"),
                    passwordHash = hashProvider.hash(request.queryParams("password")),
                    permissions = permissions
            ))

            user(user)
            response.redirect("/")
        }

        get("/edit/:username") {
            val username = request.params("username")
            val user = userService.getUser(username)
            if (user != null) {
                templateLoader.loadTemplate(
                        "/users/edit.ftl",
                        ViewModelUser(
                                user(),
                                user
                        )
                )
            } else {

            }
        }

        get("/delete/:username") {
            val username = request.params("username")
            val user = username?.let {
                userService.getUser(it)
            }

            if (user != null) {
                userService.deleteUser(user)
                response.redirect("/home")
            } else {
                TODO("Error")
            }
        }

        post("/edit/submit") {
            val username = request.queryParams("username")
            val user = username?.let {
                userService.getUser(it)
            }

            if (user != null) {
                userService.editUser(User(
                        id = user.id,
                        username = user.username,
                        passwordHash = request.queryParams("passwordHash"),
                        permissions = user.permissions
                ))
                response.redirect("/users/profile/$username")
            } else {
                TODO("Error")
            }
        }

        get("/profile/:username") {
            val username = request.params("username")
            val user = username?.let {
                userService.getUser(it)
            }

            if (user != null) {
                templateLoader.loadTemplate(
                        "/users/profile.ftl",
                        ViewModelUser(
                                user(),
                                user
                        )

                )
            } else {
                TODO("Error")
            }
        }
    }
}