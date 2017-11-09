package swen343.hr.dependencies

import com.google.inject.Singleton
import java.security.MessageDigest
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * Created by ben on 11/3/17.
 */
@Singleton
class HashProviderSha256 : HashProvider {

    private val messageDigest = MessageDigest.getInstance("SHA-256")

    override fun hash(string: String): String {
        val digest =  messageDigest.digest(
                string.toByteArray(StandardCharsets.UTF_8)
        )

        return String(Base64.getEncoder().encode(digest))
    }
}