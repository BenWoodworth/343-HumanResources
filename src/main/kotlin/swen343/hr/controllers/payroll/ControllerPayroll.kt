package swen343.hr.controllers.payroll

import com.google.inject.Inject
import com.google.inject.Singleton
import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.AccountingService
import swen343.hr.dependencies.EmployeeService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.ViewModelEmployeeList

/**
 * Created by ben on 11/7/17.
 */
@Singleton
class ControllerPayroll @Inject constructor(
        private val accountingService: AccountingService,
        private val employeeService: EmployeeService,
        private val templateLoader: TemplateLoader,
        private val routeUtil: RouteUtil
) : RouteGroup {

    override fun addRoutes() {

        get("") {
            routeUtil.requirePerms(this, Permissions.HR_PAYROLL_VIEW)

            templateLoader.loadTemplate(
                    "/payroll/payroll.ftl",
                    ViewModelEmployeeList(
                            routeUtil.user(this),
                            employeeService.getEmployees()
                    )
            )
        }

        post("/pay/:username") {
            routeUtil.requirePerms(this, Permissions.HR_PAYROLL_PAY)

            val username = params("username")
            val employee = employeeService.getEmployee(username)

            if (employee != null) {
                accountingService.requestPayroll(employee)
            } else {
                TODO("Error")
            }
        }

        post("/pay-all") {
            routeUtil.requirePerms(this, Permissions.HR_PAYROLL_PAY)

            employeeService.getEmployees().all {
                accountingService.requestPayroll(it)
            }
        }
    }
}