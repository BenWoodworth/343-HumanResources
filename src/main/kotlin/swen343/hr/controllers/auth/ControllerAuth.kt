package swen343.hr.controllers.auth

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.FormLogin

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class ControllerAuth @Inject constructor(
        private val userService: UserService,
        private val templateLoader: TemplateLoader,
        private val formLoginFactory: FormLogin.Factory,
        private val routeUtil: RouteUtil
) : RouteGroup {

    override fun addRoutes() {

        get("login/") {

            templateLoader.loadTemplate(
                    "/auth/login.ftl",
                    formLoginFactory.getForm(routeUtil.user(this))
            )
        }

        post("login/") {
            val form = formLoginFactory.getForm(
                    sessionUser = routeUtil.user(this),
                    username = request.queryParams("username"),
                    password = request.queryParams("password")
            )

            if (!form.validate()) {
                templateLoader.loadTemplate(
                        "/auth/login.ftl",
                        form
                )
            } else {

                routeUtil.user(this, userService.getUser(form.fields.username))
                response.redirect("/silos/")
            }
        }

        get("sign-out/") {
            routeUtil.user(this, null)
            response.redirect("/")
        }
    }
}
