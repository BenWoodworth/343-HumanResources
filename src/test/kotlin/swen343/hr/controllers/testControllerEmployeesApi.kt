package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerEmployeesApi: Spek({

    describe("Test the routes in controllerUsers Api"){
        it("User can access the list of employees from api/employees/ path"){
            try {
                Spark.connect("/api/v1/employees", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can access an employee's info from getting the api/employees/:username path"){
            try {
                Spark.connect("/api/v1/employees/martinez", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can access an employee's avatar by getting the api/employees/:username/avatar"){
            try {
                Spark.connect("/api/v1/employees/martinez/avatar", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }
})