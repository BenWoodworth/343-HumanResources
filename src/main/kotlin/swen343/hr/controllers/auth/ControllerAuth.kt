package swen343.hr.controllers.auth

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.User
import swen343.hr.util.Permission
import swen343.hr.util.user
import swen343.hr.viewmodels.FormLogin
import swen343.hr.viewmodels.ViewModelBasic

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class ControllerAuth @Inject constructor(
        private val userService: UserService,
        private val templateLoader: TemplateLoader,
        private val formLoginFactory: FormLogin.Factory
) : RouteGroup {

    override fun addRoutes() {

        get("/login") {
            templateLoader.loadTemplate(
                    "/auth/login.ftl",
                    formLoginFactory.getForm(user())
            )
        }

        post("/login") {
            val form = formLoginFactory.getForm(
                    sessionUser = user(),
                    username = request.queryParams("username"),
                    password = request.queryParams("password")
            )

            if (!form.validate()) {
                templateLoader.loadTemplate(
                        "/auth/login.ftl",
                        form
                )
            } else {
                user(userService.getUser(form.fields.username))
                response.redirect("/silos")
            }
        }

        get("/sign-out") {
            user(null)
            response.redirect("/")
        }
    }
}
