package swen343.hr.controllers.login

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.User

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class ControllerLogin @Inject constructor(
        private val userService: UserService,
        private val hashProvider: HashProvider,
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            templateLoader.loadTemplate("/login/login.ftl")
        }

        post("") {
            val username = request.queryParams("username")
            val password = request.queryParams("password")

            val passwordHash = password?.let { hashProvider.hash(password) }
            val user = userService.getUser(username)

            if (user?.passwordHash != passwordHash) {
                response.redirect("/login") // TODO Invalid login message
            } else {
                request.session(true).apply {
                    attribute("user", user)
                }
                response.redirect("/")
            }
        }

        post("/register") {
            userService.addUser(User(
                    username = request.queryParams("username"),
                    passwordHash = hashProvider.hash(request.queryParams("password"))
            ))
            response.redirect("/home")
        }
    }
}
