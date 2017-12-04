package swen343.hr.controllers.employees

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.HashProvider
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.dependencies.UserService
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.*

/**
 * Created by ben on 10/16/17.
 */
@Singleton
class ControllerEmployees @Inject constructor(
        private val controllerEmployeesDocuments: ControllerEmployeesDocuments,
        private val templateLoader: TemplateLoader,
        private val employeeService: EmployeeService,
        private val userService: UserService,
        private val routeUtil: RouteUtil
) : RouteGroup {

    override fun addRoutes() {

        path("", controllerEmployeesDocuments)

        get("") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_VIEW)

            templateLoader.loadTemplate(
                    "/employees/list.ftl",
                    ViewModelEmployeeList(
                            routeUtil.user(this),
                            employeeService
                                    .getEmployees()
                                    .sortedBy { it.lastName.toLowerCase() }
                    )
            )
        }

        get("add/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_ADD)

            templateLoader.loadTemplate(
                    "/employees/add.ftl",
                    FormEmployeeAdd(
                            sessionUser = routeUtil.user(this),
                            fields = FormEmployeeAdd.Fields(),
                            userService = userService,
                            employeeService = employeeService
                    )
            )
        }

        post("add/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_ADD)

            val form = FormEmployeeAdd(
                    sessionUser = routeUtil.user(this),
                    fields = FormEmployeeAdd.Fields(
                            username = queryParams("username"),
                            firstName = queryParams("firstName"),
                            lastName = queryParams("lastName"),
                            title = queryParams("title"),
                            department = queryParams("department"),
                            salary = queryParams("salary"),
                            phoneNumber = queryParams("phoneNumber"),
                            email = queryParams("email"),
                            address = queryParams("address")
                    ),
                    userService = userService,
                    employeeService = employeeService
            )

            if (!form.validate()) {
                templateLoader.loadTemplate(
                        "/employees/add.ftl",
                        form
                )
            } else {
                val employee = employeeService.addEmployee(Employee(
                        user = userService.getUser(queryParams("username"))!!,
                        firstName = queryParams("firstName"),
                        lastName = queryParams("lastName"),
                        title = queryParams("title"),
                        department = queryParams("department"),
                        salary = queryParams("salary").toInt(),
                        phoneNumber = queryParams("phoneNumber"),
                        email = queryParams("email"),
                        address = queryParams("address")
                ))
                response.redirect("/employees/view/${employee.user.username}/")
            }

        }

        get("edit/:username/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_EDIT)

            val username = request.params("username")
            val employee = employeeService.getEmployee(username)
            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/edit.ftl",
                        FormEmployeeEdit(
                                sessionUser = routeUtil.user(this),
                                fields = FormEmployeeEdit.Fields(employee),
                                employee = employee
                        )
                )
            } else {
                TODO("Error")
            }
        }

        post("edit/:username/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_EDIT)

            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                val form = FormEmployeeEdit(
                        sessionUser = routeUtil.user(this),
                        fields = FormEmployeeEdit.Fields(
                                firstName = request.queryParams("firstName"),
                                lastName = request.queryParams("lastName"),
                                title = request.queryParams("title"),
                                department = request.queryParams("department"),
                                salary = request.queryParams("salary"),
                                phoneNumber = request.queryParams("phoneNumber"),
                                email = request.queryParams("email"),
                                address = request.queryParams("address")
                        ),
                        employee = employee
                )

                if (!form.validate()) {
                    templateLoader.loadTemplate(
                            "/employees/edit.ftl",
                            form
                    )
                } else {
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
                    response.redirect("/employees/view/$username/")
                }
            } else {
                TODO("Error")
            }
        }

        post("delete/:username/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_DELETE)

            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                employeeService.deleteEmployee(employee)

                response.redirect("/employees/")
            } else {
                TODO("Error")
            }
        }

        get("view/:username/") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_VIEW)

            val username = request.params("username")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }

            if (employee != null) {
                templateLoader.loadTemplate(
                        "/employees/view.ftl",
                        ViewModelEmployee(
                                routeUtil.user(this),
                                employee
                        )

                )
            } else {
                TODO("Error")
            }
        }
    }
}