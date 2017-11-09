package swen343.hr.dependencies

import com.google.inject.Inject
import swen343.hr.models.Session
import swen343.hr.models.User
import java.security.SecureRandom
import java.util.*

/**
 * Created by ben on 11/9/17.
 */
abstract class SessionServiceAbstract @Inject constructor(
        private val hashProvider: HashProviderSha256
) : SessionService {

    protected abstract fun saveSession(session: Session)

    protected abstract fun loadSession(sessionId: String): Session?

    override fun createSession(user: User): Session {
        val random = SecureRandom()
        random.setSeed("${user.id}|${user.passwordHash}".toByteArray())
        val bytes = ByteArray(32) { 0 }
        random.nextBytes(bytes)
        val sessionId = hashProvider.hash(bytes)

        val session = Session(
                sessionId = sessionId,
                user = user,
                expiration = null
        )

        saveSession(session)

        return session
    }

    override fun getSession(sessionId: String): Session? {
        val session = loadSession(sessionId)

        session?.expiration?.let {
            if (it < Date()) {
                endSession(sessionId)
                return null
            }
        }

        return session
    }
}