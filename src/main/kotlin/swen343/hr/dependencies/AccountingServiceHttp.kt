package swen343.hr.dependencies

import com.google.inject.Singleton
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.Charset
import com.squareup.moshi.Moshi


@Singleton
class AccountingServiceHttp : AccountingService {

    val hrSiloId = 1
    val baseUrl = "accounting.kennuware.com/api"

    override fun requestPayroll(): Boolean {
        val rawData = "id=10"
        val type = "application/x-www-form-urlencoded"
        val encodedData = URLEncoder.encode(rawData, "UTF-8")
        val u = URL("$baseUrl/pay")
        val conn = u.openConnection() as HttpURLConnection
        conn.setDoOutput(true)
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Content-Type", type)
        conn.setRequestProperty("Content-Length", encodedData.length.toString())
        val os = conn.getOutputStream()
        os.write(encodedData.toByteArray())
        return true;
        }


    override fun getBudget(): Int {
        val rawData = "id=10"
        val type = "application/x-www-form-urlencoded"
        val encodedData = URLEncoder.encode(rawData, "UTF-8")
        val u = URL("$baseUrl/balance/$hrSiloId")
        val conn = u.openConnection() as HttpURLConnection
        conn.setDoOutput(true)
        conn.setRequestMethod("GET")
        conn.setRequestProperty("Content-Type", type)
        conn.setRequestProperty("Content-Length", encodedData.length.toString())
        val os = conn.getOutputStream()
        os.write(encodedData.toByteArray())
        val response = Moshi.Builder().build()
                .adapter(PayMe::class.java)
                .fromJson(encodedData.toByteArray().toString(Charset.defaultCharset()))
        return response!!.Amount
    }

    class PayMe(
            val Amount: Int
    )
}