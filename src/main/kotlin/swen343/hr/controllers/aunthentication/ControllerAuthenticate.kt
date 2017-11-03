package swen343.hr.controllers.aunthentication

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.post
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.UserService
import swen343.hr.models.User

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class ControllerAuthenticate @Inject constructor(
        private val userService: UserService,
        private val hashProvider: HashProvider
) : RouteGroup {

    override fun addRoutes() {
        post("/register") {
            userService.addUser(User(
                    username = request.queryParams("username"),
                    passwordHash = hashProvider.hash(request.queryParams("password"))
            ))
            response.redirect("/home")
        }
    }
}
