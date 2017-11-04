package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import swen343.hr.models.User
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
                users += User(
                        id = it.getInt("id"),
                        username = it.getString("userId"),
                        passwordHash = it.getString("passwordHash")
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
                User(
                        id = it.getInt("id"),
                        username = it.getString("username"),
                        passwordHash = it.getString("passwordHash")
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
                User(
                        id = it.getInt("id"),
                        username = it.getString("username"),
                        passwordHash = it.getString("passwordHash")
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
                )
            } else {
                TODO("Error")
            }
        }
    }

    override fun editUser(user: User) {
        database.connection.prepareStatement(
                "REPLACE INTO Users (id, username, passwordHash) VALUES(?, ?, ?);"
        ).apply {
            setInt(1, user.id)
            setString(2, user.username)
            setString(3, user.passwordHash)
        }.execute()
    }

    override fun deleteUser(user: User) {
        database.connection.prepareStatement(
                "DELETE FROM Users WHERE id=?;"
        ).apply {
            setInt(1, user.id)
        }.execute()
    }
}