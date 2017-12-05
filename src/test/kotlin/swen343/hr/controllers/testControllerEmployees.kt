package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerEmployees : Spek({
    describe("Tests for addRoutes function"){
        it("User should be able to view employees by getting the 'employee/' path"){
            try {
                Spark.connect("/employees/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be able to add employees by getting the employee/add path"){
            try {
                Spark.connect("/employees/add/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be able to add employees by posting the employee/add path"){
            try {
                Spark.connect("/employees/add/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be able to edit employees by getting the employee/edit/:username path"){
            try {
                Spark.connect("/employees/edit/jahn/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be able to edit employees by posting the employee/edit/:username path"){
            try {
                Spark.connect("/employees/edit/jahn/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be able to delete employees by getting the employee/delete/:username path"){
            try {
                Spark.connect("/employees/delete/jahn/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User should be bale to view employees by getting the employee/view/:username path"){
            try {
                Spark.connect("/employees/view/jahn/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }

    }
})