package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerUsersApi: Spek({
    describe("Test the routes in controllerUsers Api"){
        it("User can access the list of users from the api/users/ path"){
            try {
                Spark.connect("/auth/users", "GET ") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can access a user's info from getting the api/users/:username path"){
            try {
                Spark.connect("/auth/users/:username", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can access a user's permissiong by getting the api/users/:username/has-perm/:permission path"){
            try {
                Spark.connect("/api/users/:username/has-perm/:permission", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }
})