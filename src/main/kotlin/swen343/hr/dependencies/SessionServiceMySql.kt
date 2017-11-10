package swen343.hr.dependencies

import com.google.inject.Inject
import swen343.hr.models.Session
import swen343.hr.util.connect

class SessionServiceMySql @Inject constructor(
        private val database: DatabaseMySql,
        private val userService: UserService
) : SessionServiceAbstract() {

    override fun saveSession(session: Session) {
        database.connect {
            prepareStatement(
                    """
                        INSERT INTO Sessions (
                          token,
                          userId,
                          ipAddress,
                          expiration
                        ) VALUES(?, ?, ?, ?);
                    """
            ).apply {
                setString(1, session.token)
                setInt(2, session.user.id)
                setString(3, session.ipAddress)
                setDate(4, session.expiration)
            }.execute()
        }
    }

    override fun loadSession(token: String): Session? {
        database.connect {
            prepareStatement(
                    """
                        SELECT * FROM Sessions
                          WHERE token=?;
                    """
            ).apply {
                setString(1, token)
            }.executeQuery().use {
                if (it.next()) {
                    return Session(
                            token = it.getString("token"),
                            user = userService.getUser(it.getInt("userId"))!!,
                            ipAddress = it.getString("ipAddress"),
                            expiration = it.getDate("expiration")
                    )
                }
            }
        }
        return null
    }

    override fun endSession(token: String) {
        database.connect {
            prepareStatement(
                    "DELETE FROM Sessions WHERE token=?;"
            ).apply {
                setString(1, token)
            }.execute()
        }
    }
}