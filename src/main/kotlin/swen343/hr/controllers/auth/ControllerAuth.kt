package swen343.hr.controllers.auth

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.Response
import spark.RouteGroup
import spark.kotlin.RouteHandler
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.controllers.RequestHandler
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.User
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.FormLogin

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class ControllerAuth @Inject constructor(
        private val routeUtil: RouteUtil,

        private val getLogin: GetLogin,
        private val postLogin: PostLogin
) : RouteGroup {

    override fun addRoutes() {

        get("login/") {
            getLogin(this)
        }

        post("login/") {
            postLogin(this)
        }

        get("sign-out/") {
            routeUtil.user(this, null)
            response.redirect("/")
        }
    }

    class GetLogin @Inject constructor(
            private val formLoginFactory: FormLogin.Factory
    ) : RequestHandler.Basic() {

        override fun handleRequest(routeHandler: RouteHandler) {
            templateLoader.loadTemplate(
                    "/auth/login.ftl",
                    formLoginFactory.getForm(routeUtil.user(routeHandler))
            )
        }
    }

    class PostLogin @Inject constructor(
            private val formLoginFactory: FormLogin.Factory,
            private val userService: UserService
    ) : RequestHandler<FormLogin>() {

        class Data(
                val username: String,
                val password: String
        )

        override val dataMapper: RouteHandler.() -> FormLogin = {
            formLoginFactory.getForm(
                    sessionUser = routeUtil.user(this),
                    username = queryParams("username"),
                    password = queryParams("password")
            )
        }

        override fun handleRequest(data: FormLogin, routeHandler: RouteHandler) {
            if (!data.validate()) {
                templateLoader.loadTemplate(
                        "/auth/login.ftl",
                        data
                )
            } else {
                routeUtil.user(routeHandler, userService.getUser(data.fields.username))
                routeHandler.response.redirect("/silos/")
            }
        }
    }

    class GetSignOut @Inject constructor() : RequestHandler.Basic() {

        override fun handleRequest(routeHandler: RouteHandler) {
            templateLoader.loadTemplate(
                    "/auth/login.ftl",
                    formLoginFactory.getForm(routeUtil.user(routeHandler))
            )
        }
    }
}
