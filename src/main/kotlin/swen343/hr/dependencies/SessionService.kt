package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Session
import swen343.hr.models.User

/**
 * Created by ben on 11/9/17.
 */
@ImplementedBy(SessionServiceMySql::class)
interface SessionService {

    /**
     * Creates a session for a user.
     *
     * @return a new session
     */
    fun createSession(user: User, ipAddress: String?): Session

    /**
     * End a user's session.
     */
    fun endSession(token: String)

    /**
     * Gets a session from a session ID.
     *
     * @return a session, or `null` if it's expired or nonexistent.
     */
    fun getSession(token: String, ipAddress: String?): Session?
}