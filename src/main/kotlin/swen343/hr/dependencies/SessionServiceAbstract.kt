package swen343.hr.dependencies

import com.google.inject.Inject
import swen343.hr.models.Session
import swen343.hr.models.User
import java.security.SecureRandom

/**
 * Created by ben on 11/9/17.
 */
abstract class SessionServiceAbstract @Inject constructor(
        private val hashProvider: HashProviderSha256
) : SessionService {

    abstract fun loadSession(sessionId: String): Session?

    abstract fun saveSession(sessionId: String)

    private fun getSalt(user: User, ip: String): Long {
        val random = SecureRandom()
        random.setSeed("${user.id}|${user.passwordHash}|$ip".toByteArray())
        return random.nextLong()
    }

    override fun createSession(user: User, ip: String): Session {
        val salt = random.
        val key = hashProvider.hash("${user.id}{")
    }

    override fun getSession(sessionId: String): Session? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}