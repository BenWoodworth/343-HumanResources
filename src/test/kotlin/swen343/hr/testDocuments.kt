package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testDocuments : Spek({

    describe("Tests for uploading a document"){
        it("User should be able to upload a document"){
            try {
                Spark.connect("/employees/martinez/documents/upload/Resume.txt", "POST") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }

    describe("Tests for deleting a document"){
        it("User should be able to delete a document"){
            try {
                Spark.connect("/employees/martinez/documents/delete/Resume.txt", "POST") { _, response ->
                    assertEquals(200, response.status())
                }
            } catch (exception: HTTPException) {
                fail("Should not throw exception")
            }
        }
    }
})