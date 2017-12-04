package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.models.Employee
import java.util.ArrayList
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.Charset
import kotlin.experimental.and
import com.squareup.moshi.Moshi


@Singleton
class AccountingServiceHttp : AccountingService {

    val accountingURL = "accounting.kennuware.com/api"
    val siloId : 1
    val payroll

    override fun requestPayroll(): Boolean {
        val rawData = "id=10"
        val type = "application/x-www-form-urlencoded"
        val encodedData = URLEncoder.encode(rawData, "UTF-8")
        val u = URL("$accountingURL/pay")
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
        val u = URL("$accountingURL/balance/$siloId")
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

    class PayMe(val Amount :Int)
}