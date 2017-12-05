package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerIndex: Spek({
    describe("Tests for addRoutes in the Index."){
        it("Users access controllerApi by using the path /api"){
            try {
                Spark.connect("/api/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users access controllerEmployees by using the path /employees"){
            try {
                Spark.connect("/employees/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users access controllerUsers by using the path /users"){
            try {
                Spark.connect("/users/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users access controllerAuth by using the path /auth"){
            try {
                Spark.connect("/auth/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users are redirected to the log in when not logged in when getting the '/' path"){
            try {
                Spark.connect("/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users are directed to the silos page when signed in when getting the /silos path"){
            try {
                Spark.connect("/silos/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }

})