package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import spark.Spark
import javax.xml.ws.http.HTTPException
import kotlin.test.assertEquals
import kotlin.test.fail

class testDeleteEmployee : Spek({
    describe("Users should be able to delete employees"){
        try {
            Spark.connect("/employees/martinez/delete/", "POST") { _, response ->
                assertEquals(200, response.status())
            }
        } catch (exception: HTTPException) {
            fail("Should not throw exception")
        }
    }
})