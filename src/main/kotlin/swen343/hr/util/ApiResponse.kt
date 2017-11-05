package swen343.hr.util

import com.squareup.moshi.Moshi
import spark.Response

class ApiResponse private constructor(
        val response: Any?,
        val error: String?
) {

    constructor(responseObject: Any) : this(responseObject, null)

    constructor(errorMessage: String) : this(null, errorMessage)

    fun jsonResponse(res: Response? = null): String {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(ApiResponse::class.java)
        val json = adapter.toJson(this)

        res?.apply {
            type("application/json")
            body(json)

            if (response != null) {
                status(200) // OK
            } else {
                status(400) // Bad request
            }
        }

        return json
    }
}