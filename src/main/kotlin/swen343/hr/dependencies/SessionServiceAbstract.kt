package swen343.hr.dependencies

import com.google.inject.Inject
import swen343.hr.models.Session
import swen343.hr.models.User
import java.security.SecureRandom
import java.sql.Date

/**
 * Created by ben on 11/9/17.
 */
abstract class SessionServiceAbstract : SessionService {

    @Inject private lateinit var hashProvider: HashProviderSha256
    @Inject private lateinit var config: Config

    protected abstract fun saveSession(session: Session)

    protected abstract fun loadSession(token: String): Session?

    override fun createSession(user: User, ipAddress: String?): Session {
        val random = SecureRandom()
        random.setSeed("${user.id}|${user.passwordHash}".toByteArray())
        val bytes = ByteArray(32) { 0 }
        random.nextBytes(bytes)
        val token = hashProvider.hash(bytes)
                .replace('/', '_')
                .replace('+', '-')
                .replace("=", "")

        val duration = config.sessionDurationSeconds?.let {
            it * 1000
        }
        val expiration = duration?.let {
            Date(System.currentTimeMillis() + duration)
        }

        val session = Session(
                token = token,
                user = user,
                ipAddress = ipAddress,
                expiration = expiration
        )

        saveSession(session)

        return session
    }

    override fun getSession(token: String, ipAddress: String?): Session? {
        val session = loadSession(token)

        session?.expiration?.let {
            if (it < Date(System.currentTimeMillis())) {
                endSession(token)
                return null
            }
        }

        session?.ipAddress ?: return session

        if (session.ipAddress != ipAddress) {
            return null
        }

        return session
    }
}