package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerEmployeesApi: Spek({

    describe("Test the routes in controllerUsers Api"){
        it("User can access the list of employees from api/employees/ path"){}
        it("User can access an employee's info from getting the api/employees/:username path"){}
        it("User can access an employee's avatar by getting the api/employees/:username/has-perm/:permission path"){}
    }
})