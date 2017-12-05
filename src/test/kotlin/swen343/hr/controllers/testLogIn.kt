package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testLogin : Spek({

    describe("Testing logging in"){
        it("Should log in when provided a correct username and password."){
            try {
                Spark.connect("/auth/login/?username=admin&password=password", "POST") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Should not log in with the wrong username "){
            try {
                Spark.connect("/auth/login/?username=wrong-admin&password=password", "POST") { _, response ->
                    assertEquals(500, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Should not log in with the wrong password "){
            try {
                Spark.connect("/auth/login/?username=admin&password=wrong-password", "POST") { _, response ->
                    assertEquals(500, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }


    describe("Testing signing out"){
        it("Should sign out when hitting the sign out buttons"){
            try {
                Spark.connect("/auth/sign-out/", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
        it("Should not sign out when a user is not logged in"){
            try {
                Spark.connect("/auth/sign-out-wrong", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }

})