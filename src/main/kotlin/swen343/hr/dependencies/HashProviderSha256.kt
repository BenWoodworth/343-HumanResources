package swen343.hr.dependencies

import com.google.inject.Singleton
import java.security.MessageDigest
import java.nio.charset.StandardCharsets


/**
 * Created by ben on 11/3/17.
 */
@Singleton
class HashProviderSha256 : HashProvider {

    private val messageDigest = MessageDigest.getInstance("SHA-256")

    ///////////////////////////////////////// DO NOT CHANGE!
    private val salt: String = "j4cKd4dDy" // PASSWORDS WILL
    ///////////////////////////////////////// BE INVALIDATED

    override fun hash(string: String): List<Byte> {
        val salted = "$salt$string"

        return messageDigest
                .digest(salted.toByteArray(StandardCharsets.UTF_8))
                .toList()
    }
}