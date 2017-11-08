package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.Permission
import java.sql.Statement

@Singleton
class UserServiceMySql @Inject constructor(
        private val database: DatabaseMySql
) : UserService {

    override fun getUsers(): List<User> {
        database.connection.createStatement().executeQuery(
                "SELECT * FROM Users;"
        ).use {
            val users = mutableListOf<User>()
            while (it.next()) {
                val id = it.getInt("id")

                users += User(
                        id = id,
                        username = it.getString("username"),
                        passwordHash = it.getString("passwordHash"),
                        permissions = getPermissions(id)
                )
            }
            return users
        }
    }

    override fun getUser(id: Int): User? {
        database.connection.prepareStatement(
                "SELECT * FROM Users WHERE id=?;"
        ).apply {
            setInt(1, id)
        }.executeQuery().use {
            return if (it.next()) {
                val id = it.getInt("id")
                User(
                        id = id,
                        username = it.getString("username"),
                        passwordHash = it.getString("passwordHash"),
                        permissions = getPermissions(id)
                )
            } else {
                null
            }
        }
    }

    override fun getUser(username: String): User? {
        database.connection.prepareStatement(
                "SELECT * FROM Users WHERE username=?;"
        ).apply {
            setString(1, username)
        }.executeQuery().use {
            return if (it.next()) {
                val id = it.getInt("id")
                User(
                        id = id,
                        username = it.getString("username"),
                        passwordHash = it.getString("passwordHash"),
                        permissions = getPermissions(id)
                )
            } else {
                null
            }
        }
    }

    override fun addUser(user: User): User {
        database.connection.prepareStatement(
                "INSERT INTO Users (username, passwordHash) VALUES(?, ?);",
                Statement.RETURN_GENERATED_KEYS
        ).apply {
            setString(1, user.username)
            setString(2, user.passwordHash)
        }.apply {
            execute()
        }.generatedKeys.use {
            if (it.next()) {
                return user.copy(
                        id = it.getInt(1)
                ).also {
                    setPermissions(it.id, user.permissions)
                }
            } else {
                TODO("Error")
            }
        }
    }

    override fun editUser(user: User) {
        database.connection.prepareStatement(
                """
                    UPDATE Users
                    SET username=?,
                        passwordHash=?
                    WHERE id=?
                  """
        ).apply {
            setString(1, user.username)
            setString(2, user.passwordHash)
            setInt(3, user.id)
        }.execute()

        setPermissions(user.id, user.permissions)
    }

    override fun deleteUser(user: User) {
        setPermissions(user.id, emptyList())

        database.connection.prepareStatement(
                "DELETE FROM Users WHERE id=?;"
        ).apply {
            setInt(1, user.id)
        }.execute()
    }

    private fun getPermissions(userId: Int): List<Permission> {
        database.connection.prepareStatement(
                "SELECT (permission) FROM Permissions WHERE userId=?;"
        ).apply {
            setInt(1, userId)
        }.executeQuery().use {
            val permissions = mutableListOf<Permission>()
            while (it.next()) {
                permissions += Permission(
                        it.getString("permission")
                )
            }
            return permissions.toList()
        }
    }

    private fun setPermissions(userId: Int, permissions: List<Permission>) {
        database.connection.prepareStatement(
                "DELETE FROM Permissions WHERE userId=?;"
        ).apply {
            setInt(1, userId)
        }.execute()

        permissions.forEach { permission ->
            database.connection.prepareStatement(
                    """
                        INSERT INTO Permissions (
                          userId,
                          permission
                        ) VALUES(?, ?);
                    """
            ).apply {
                setInt(1, userId)
                setString(2, permission.toString())
            }.execute()
        }
    }
}