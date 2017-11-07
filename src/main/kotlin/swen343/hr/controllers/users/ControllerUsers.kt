package swen343.hr.controllers.users

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.UserService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.models.User
import swen343.hr.util.Permission
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.FormUserEdit
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
        private val hashProvider: HashProvider,
        private val routeUtil: RouteUtil,
        private val formUserEditFactory: FormUserEdit.Factory
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_VIEW)
            templateLoader.loadTemplate(
                    "/users/list.ftl",
                    ViewModelUserList(
                            routeUtil.user(this),
                            userService
                                    .getUsers()
                                    .sortedBy { it.username.toLowerCase() }
                    )
            )
        }

        get("/add") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_ADD)
            templateLoader.loadTemplate(
                    "/users/add.ftl",
                    ViewModelBasic(routeUtil.user(this))
            )
        }

        post("/add") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_ADD)
            val permissions = request
                    .queryParams("permissions")
                    .split(Regex("\\v+"))
                    .map { Permission(it) }

            val user = userService.addUser(User(
                    username = request.queryParams("username"),
                    passwordHash = hashProvider.hash(request.queryParams("password")),
                    permissions = permissions
            ))

            routeUtil.user(this, user)
            response.redirect("/")
        }

        get("/edit/:username") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_EDIT)
            val username = params("username")
            val user = userService.getUser(username)

            if (user != null) {
                templateLoader.loadTemplate(
                        "/users/edit.ftl",
                        formUserEditFactory.getForm(
                                sessionUser = routeUtil.user(this),
                                fields = FormUserEdit.Fields(user),
                                user = user
                        )
                )
            } else {

            }
        }

        post("/edit/:username") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_EDIT)
            val username = params("username")
            val user = userService.getUser(username)

            if (user != null) {
                val form = formUserEditFactory.getForm(
                        sessionUser = routeUtil.user(this),
                        fields = FormUserEdit.Fields(
                                username = queryParams("username"),
                                newPassword = queryParams("newPassword"),
                                newPasswordConfirm = queryParams("newPasswordConfirm"),
                                permissions = queryParams("permissions")
                        ),
                        user = user
                )

                if (form.validate()) {
                    val passHash = if (form.fields.newPassword == "") {
                        user.passwordHash
                    } else {
                        hashProvider.hash(form.fields.newPassword)
                    }

                    val permissions = form.fields.permissions
                            .split(Regex("\\v"))
                            .map { Permission(it) }

                    val newUser = user.copy(
                            username = form.fields.username,
                            passwordHash = passHash,
                            permissions = permissions
                    )

                    userService.editUser(newUser)

                    response.redirect("/users/view/${newUser.username}")
                } else {
                    templateLoader.loadTemplate(
                            "/users/edit.ftl",
                            form
                    )
                }
            } else {
                TODO("Error")
            }
        }

        get("/delete/:username") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_DELETE)
            val username = request.params("username")
            val user = username?.let {
                userService.getUser(it)
            }

            if (user != null) {
                userService.deleteUser(user)
                response.redirect("/users")
            } else {
                TODO("Error")
            }
        }

        get("/view/:username") {
            routeUtil.requirePerms(this, Permissions.HR_USERS_VIEW)
            val username = request.params("username")
            val user = username?.let {
                userService.getUser(it)
            }

            if (user != null) {
                templateLoader.loadTemplate(
                        "/users/view.ftl",
                        ViewModelUser(
                                routeUtil.user(this),
                                user
                        )
                )
            } else {
                TODO("Error")
            }
        }
    }
}