package swen343.hr.dependencies

import com.google.inject.Singleton
import java.security.MessageDigest
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * Created by ben on 11/3/17.
 */
@Singleton
class HashServiceSha256 : HashService {

    private val messageDigest = MessageDigest.getInstance("SHA-256")

    ///////////////////////////////////////// DO NOT CHANGE!
    private val salt: String = "j4cKd4dDy" // PASSWORDS WILL
    ///////////////////////////////////////// BE INVALIDATED

    override fun hash(string: String): String {
        val salted = "$salt$string"

        val digest =  messageDigest.digest(
                salted.toByteArray(StandardCharsets.UTF_8)
        )

        return String(Base64.getEncoder().encode(digest))
    }
}