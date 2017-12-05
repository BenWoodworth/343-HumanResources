package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testControllerAuth: Spek({

    describe("Tests to the paths in addRoutes()"){

        it("Users are able to log in using by getting the auth/login path"){
            try {
                Spark.connect("/auth/login", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }

        it("Users are able to log in by posting to the auth/login path"){
            try {
                Spark.connect("/auth/login?username=admin&password=password", "POST") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }

        it("Users are able to sign out by using the auth/sign-out path"){
            try {
                Spark.connect("/auth/sign-out", "GET") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }
})