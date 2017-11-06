package swen343.hr.controllers.employees

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.requirePerms
import swen343.hr.util.user
import swen343.hr.viewmodels.ViewModelBasic
import swen343.hr.viewmodels.ViewModelEmployee
import swen343.hr.viewmodels.ViewModelEmployeeList

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class ControllerEmployees @Inject constructor(
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService,
        private val userService: UserService,
        private val hashProvider: HashProvider
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            requirePerms(Permissions.HR_EMPLOYEES_VIEW)

            templateLoader.loadTemplate(
                    "/employees/employees.ftl",
                    ViewModelEmployeeList(
                            user(),
                            employeeService
                                    .getEmployees()
                                    .sortedBy { it.lastName.toLowerCase() }
                    )
            )
        }

        get("/add") {
            requirePerms(Permissions.HR_EMPLOYEES_ADD)

            templateLoader.loadTemplate(
                    "/employees/add.ftl",
                    ViewModelBasic(user())
            )
        }

        post("/add") {
            requirePerms(Permissions.HR_EMPLOYEES_ADD)

            val employee = employeeService.addEmployee(Employee(
                    user = userService.addUser(User(
                            username = request.queryParams("username"),
                            passwordHash = hashProvider.hash(request.queryParams("password")),
                            permissions = listOf() // TODO
                    )),
                    firstName = request.queryParams("firstName"),
                    lastName = request.queryParams("lastName"),
                    title = request.queryParams("title"),
                    department = request.queryParams("department"),
                    salary = request.queryParams("salary").toInt(),
                    phoneNumber = request.queryParams("phoneNumber"),
                    email = request.queryParams("email"),
                    address = request.queryParams("address")
            ))
            response.redirect("/employees/profile/${employee.user.username}")
        }

        get("/edit/:username") {
            requirePerms(Permissions.HR_EMPLOYEES_EDIT)

            val username = request.params("username")
            val employee = employeeService.getEmployee(username)
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        ViewModelEmployee(
                                user(),
                                employee
                        )
                )
            } else {

            }
        }

        get("/delete/:username") {
            requirePerms(Permissions.HR_EMPLOYEES_DELETE)

            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                employeeService.deleteEmployee(employee)
                response.redirect("/home")
            } else {
                TODO("Error")
            }
        }

        post("/edit/submit") {
            requirePerms(Permissions.HR_EMPLOYEES_EDIT)


            val username = request.queryParams("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                employeeService.editEmployee(Employee(
                        id = employee.id,
                        user = employee.user,
                        firstName = request.queryParams("firstName"),
                        lastName = request.queryParams("lastName"),
                        title = request.queryParams("title"),
                        department = request.queryParams("department"),
                        salary = request.queryParams("salary").toInt(),
                        phoneNumber = request.queryParams("phoneNumber"),
                        email = request.queryParams("email"),
                        address = request.queryParams("address")
                ))
                response.redirect("/employees/profile/$username")
            } else {
                TODO("Error")
            }
        }

        get("/profile/:username") {
            requirePerms(Permissions.HR_EMPLOYEES_VIEW)

            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/profile.ftl",
                        ViewModelEmployee(
                                user(),
                                employee
                        )

                )
            } else {
                TODO("Error")
            }
        }
    }
}