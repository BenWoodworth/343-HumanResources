package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import com.squareup.moshi.Moshi
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.Charset

@Singleton
class AccountingServiceHttp @Inject constructor(
        private val employeeService: EmployeeService
) : AccountingService {

    private val hrSiloId = 1
    private val baseUrl = "http://accounting.kennuware.com/api"

    private val charset = "UTF-8"

    override fun requestPayroll(): Boolean {
        val amount = employeeService
                .getEmployees()
                .sumBy { it.salary }

        return try {
            request(
                    "$baseUrl/pay",
                    "POST",
                    """
                        {
                            "reason": "Pay salaries",
                            "amount": $amount
                        }
                    """
            )
            true
        } catch(e: Exception) {
            false
        }
    }

    override fun getBudget(): Int {
        class BudgetResponse(val Amount: Int)

        val response = request(
                "$baseUrl/balance/$hrSiloId",
                "GET"
        )

        return Moshi.Builder().build()
                .adapter(BudgetResponse::class.java)
                .fromJson(response)!!
                .Amount
    }

    fun request(url: String, method: String, body: String = ""): String {
        val dataBytes = body.toByteArray(Charset.forName(charset))

        with(URL(url).openConnection()) {
            charset(charset)

            doOutput = true
            doInput = true

            getOutputStream().use {
                it.write(dataBytes)
            }

            getInputStream().bufferedReader(Charset.forName(charset)).use {
                return it.lineSequence()
                        .joinToString("\n")
            }
        }
    }

    fun request(url: String, method: String, formData: Map<String, String>): String {
        val body = formData
                .map {
                    val key = URLEncoder.encode(it.key, charset)
                    val value = URLEncoder.encode(it.value, charset)

                    "$key=$value"
                }
                .joinToString("&")

        return request(url, method, body)
    }
}