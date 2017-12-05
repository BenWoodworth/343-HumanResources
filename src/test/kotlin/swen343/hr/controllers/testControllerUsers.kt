package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerUsers : Spek({
    describe("Test the routes for the ControllerUsers class"){
        it("Users can access the user list by getting the 'users/' path"){
            try {
                Spark.connect("/users//", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users can add to the user list by getting the user/add path"){
            try {
                Spark.connect("/users/add/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users can add to the user list by posting to the user/add path"){
            try {
                Spark.connect("/users/add/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users can edit to the user list by getting the user/edit/:username path"){
            try {
                Spark.connect("/users/edit/admin", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Users can edit the user list by posting to the user/edit/:username"){
            try {
                Spark.connect("/users/edit/admin/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can delete a user from the list by getting the user/delete/:username path"){
            try {
                Spark.connect("/users/delete/admin/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("User can view a user from the list by getting the user/view/:username path"){
            try {
                Spark.connect("/users/view/admin/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }
})
