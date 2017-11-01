package swen343.hr.controllers.aunthentication

import com.google.inject.Inject
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.UserService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.User


/**
 * Created by beltran on 11/01/17.
 */
class ControllerAuthenicate @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val userService: UserService
) : RouteGroup {

    override fun addRoutes() {

        post("/register") {
            val user = User(
                    email = request.queryParams("email"),
                    password = request.queryParams("password"),
                    department = request.queryParams("department")
            )
            userService.updateUser(user)
            response.redirect("/home")
        }

    }
}
