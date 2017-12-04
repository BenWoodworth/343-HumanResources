package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.models.Employee
import java.util.ArrayList
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import kotlin.experimental.and


@Singleton
class AccountingServiceHttp : AccountingService {

    val accountingURL = "accounting.kennuware.com/api"
    val siloId : Int

    constructor(siloId : Int){
        this.siloId = siloId
    }

    override fun requestPayroll(employee: Employee): Boolean {
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


    // packing an array of 4 bytes to an int, big endian
//    fun fromByteArray(bytes: ByteArray): Int {
//        return bytes[0] shl 24 or (bytes[1] and 0xFF shl 16) or (bytes[2] and 0xFF shl 8) or (bytes[3] and 0xFF)
//    }


    override fun getBudget(): Int {
        val rawData = "id=10"
        val type = "application/x-www-form-urlencoded"
        val encodedData = URLEncoder.encode(rawData, "UTF-8")
        val u = URL("$accountingURL/balance/$siloId")
        val conn = u.openConnection() as HttpURLConnection
        conn.setDoOutput(true)
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Content-Type", type)
        conn.setRequestProperty("Content-Length", encodedData.length.toString())
        val os = conn.getOutputStream()
        os.write(encodedData.toByteArray())
        print(os.write(encodedData.toByteArray()))

    }
}