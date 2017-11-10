package swen343.hr.controllers.payroll

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.mockito.Mockito.*
import spark.Spark
import swen343.hr.dependencies.*
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.RouteUtil
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by ben on 11/7/17.
 */
class ControllerPayrollSpec : Spek({
    Spark.port(12345)
    Spark.init()
    Spark.awaitInitialization()

    val employee0 = Employee(
            id = 0,
            user = User(
                    id = 0,
                    username = "0",
                    passwordHash = "",
                    permissions = emptyList()
            ),
            firstName = "",
            lastName = "",
            address = "",
            email = "",
            phoneNumber = "",
            salary = 0,
            department = "",
            title = ""
    )

    val employee1 = employee0.copy(
            id = 1,
            user = employee0.user.copy(id = 1)
    )

    val employee2 = employee0.copy(
            id = 2,
            user = employee0.user.copy(id = 2)
    )

    val employees = listOf(employee0, employee1, employee2)

    val employeeService = mock(EmployeeService::class.java)
    `when`(employeeService.getEmployees()).thenReturn(employees)
    `when`(employeeService.getEmployee("0")).thenReturn(employee0)
    `when`(employeeService.getEmployee("1")).thenReturn(employee1)
    `when`(employeeService.getEmployee("2")).thenReturn(employee2)

    val accountingService = mock(AccountingService::class.java)
    val sessionService = mock(SessionService::class.java)

    val payroll = ControllerPayroll(
            employeeService = employeeService,
            templateLoader = TemplateLoaderResource(),
            accountingService = accountingService,
            routeUtil = RouteUtil(sessionService)
    )

    describe("the payroll controller") {
        on("a pay employee request for a single employee") {
            it("should use the accounting service for payroll") {
                val url = URL("http://localhost:${Spark.port()}/payroll/pay/1")
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.doOutput = true
                conn.connect()

                verify(accountingService, times(0)).requestPayroll(employee0)
                verify(accountingService, times(1)).requestPayroll(employee1)
                verify(accountingService, times(0)).requestPayroll(employee2)
            }
        }

        on("a pay employee request for every employee") {
            it("should use the accounting service for payroll for each employee") {
                val url = URL("http://localhost:${Spark.port()}/payroll/pay-all")
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.doOutput = true
                conn.connect()

                verify(accountingService, times(1)).requestPayroll(employee0)
                verify(accountingService, times(1)).requestPayroll(employee1)
                verify(accountingService, times(1)).requestPayroll(employee2)
            }
        }
    }
})