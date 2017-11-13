package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import swen343.hr.models.User
import swen343.hr.util.Permission
import swen343.hr.util.connect
import java.sql.Statement

@Singleton
class UserServiceMySql @Inject constructor(
        private val database: DatabaseMySql
) : UserService {

    override fun getUsers(): List<User> {
        database.connect {
            createStatement().executeQuery(
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
        return emptyList()
    }

    override fun getUser(id: Int): User? {
        database.connect {
            prepareStatement(
                    "SELECT * FROM Users WHERE id=?;"
            ).apply {
                setInt(1, id)
            }.executeQuery().use {
                if (it.next()) {
                    val newId = it.getInt("id")
                    return User(
                            id = newId,
                            username = it.getString("username"),
                            passwordHash = it.getString("passwordHash"),
                            permissions = getPermissions(newId)
                    )
                }
            }
        }
        return null
    }

    override fun getUser(username: String): User? {
        database.connect {
            prepareStatement(
                    "SELECT * FROM Users WHERE username=?;"
            ).apply {
                setString(1, username)
            }.executeQuery().use {
                if (it.next()) {
                    val id = it.getInt("id")
                    return User(
                            id = id,
                            username = it.getString("username"),
                            passwordHash = it.getString("passwordHash"),
                            permissions = getPermissions(id)
                    )
                }
            }
        }
        return null
    }

    override fun addUser(user: User): User {
        database.connect {
            prepareStatement(
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
                }
            }
        }
        TODO("Error")
    }

    override fun editUser(user: User) {
        database.connect{
            prepareStatement(
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
    }

    override fun deleteUser(user: User) {
        database.connect {
            prepareStatement(
                    "DELETE FROM Users WHERE id=?;"
            ).apply {
                setInt(1, user.id)
            }.execute()
        }
    }

    private fun getPermissions(userId: Int): List<Permission> {
        database.connect {
            prepareStatement(
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
        TODO("Error")
    }

    private fun setPermissions(userId: Int, permissions: List<Permission>) {
        database.connect {
            prepareStatement(
                    "DELETE FROM Permissions WHERE userId=?;"
            ).apply {
                setInt(1, userId)
            }.execute()

            permissions.forEach { permission ->
                prepareStatement(
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
}