package swen343.hr.dependencies

import swen343.hr.models.Session
import swen343.hr.models.User

/**
 * Created by ben on 11/9/17.
 */
interface SessionService {

    /**
     * Creates a session for a user.
     *
     * @return a new session
     */
    fun createSession(user: User, ip: String): Session

    /**
     * Gets a session from a session ID.
     *
     * @return a session, or `null` if it's expired or nonexistent.
     */
    fun getSession(sessionId: String): Session?
}