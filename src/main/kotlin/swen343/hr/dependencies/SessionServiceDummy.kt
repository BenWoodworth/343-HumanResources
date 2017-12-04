package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Session

/**
 * Created by ben on 11/9/17.
 */
@Singleton
class SessionServiceDummy @Inject constructor(
        private val userService: UserService
) : SessionServiceAbstract() {

    private val sessions = mutableListOf<Session>()

    override fun endSession(token: String) {
        sessions.removeIf {
            it.token == token
        }
    }

    override fun saveSession(session: Session) {
        sessions += session
    }

    override fun loadSession(token: String): Session? {
        val session = sessions.firstOrNull {
            it.token == token
        }

        val user = session?.user?.let {
            userService.getUser(it.id)
        }

        return user?.let {
            session.copy(user = user)
        }
    }
}