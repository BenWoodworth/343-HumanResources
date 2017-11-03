package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

import swen343.hr.controllers.api.ControllerApi
import swen343.hr.dependencies.EmployeeService

class ControllerApiTest: Spek({

    describe("Controller for the API."){
        val employeeService = mock(EmployeeService::class.java)
        `when`(employeeService.getEmployee("dad")).thenReturn(null)

        val api = ControllerApi()

        it("")

    }

})