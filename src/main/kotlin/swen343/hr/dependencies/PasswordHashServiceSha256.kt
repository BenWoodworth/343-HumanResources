package swen343.hr.dependencies

import java.security.MessageDigest
import java.nio.charset.StandardCharsets


/**
 * Created by ben on 11/3/17.
 */
class PasswordHashServiceSha256 : PasswordHashService {

    private val messageDigest = MessageDigest.getInstance("SHA-256")

    ///////////////////////////////////////// DO NOT CHANGE!
    private val salt: String = "j4cKd4dDy" // PASSWORDS WILL
    ///////////////////////////////////////// BE INVALIDATED

    override fun hashPassword(password: String): List<Byte> {
        val salted = "$salt$password"

        return messageDigest
                .digest(salted.toByteArray(StandardCharsets.UTF_8))
                .toList()
    }
}