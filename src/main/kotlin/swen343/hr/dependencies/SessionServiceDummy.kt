package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Session

/**
 * Created by ben on 11/9/17.
 */
@Singleton
class SessionServiceDummy @Inject constructor(
        hashProvider: HashProviderSha256,
        private val userService: UserService
) : SessionServiceAbstract(hashProvider) {

    private val sessions: MutableList<Session>()

    override fun endSession(sessionId: String) {
        sessions.removeIf {
            it.sessionId == sessionId
        }
    }

    override fun saveSession(session: Session) {
        sessions += session
    }

    override fun loadSession(sessionId: String): Session? {
        return sessions.firstOrNull {
            it.sessionId == sessionId
        }
    }
}