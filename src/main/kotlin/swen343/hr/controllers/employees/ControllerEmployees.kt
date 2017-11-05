package swen343.hr.controllers.employees

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.user
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
            templateLoader.loadTemplate(
                    "/employees/employees.ftl",
                    ViewModelEmployeeList(
                            session().user(),
                            employeeService
                                    .getEmployees()
                                    .sortedBy { it.lastName.toLowerCase() }
                    )
            )
        }

        get("/add") {
            templateLoader.loadTemplate(
                    "/employees/add.ftl"
            )
        }

        post("/add") {
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
            val username = request.params("username")
            val employee = employeeService.getEmployee(username)
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        ViewModelEmployee(
                                session().user(),
                                employee
                        )
                )
            } else {

            }
        }

        get("/delete/:username") {
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
            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/profile.ftl",
                        ViewModelEmployee(
                                session().user(),
                                employee
                        )

                )
            } else {
                TODO("Error")
            }
        }
    }
}