package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.models.User

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class UserServiceDummy : UserService {

    private val users = mutableListOf<User>()

    override fun getUsers() = users.toList()

    override fun getUser(username: String): User? {
        return users.firstOrNull {
            it.username == username
        }
    }

    override fun updateUser(user: User) {
        deleteUser(user.username)
        users.add(user)
    }

    override fun deleteUser(username: String) {
        users.removeIf {
            it.username == username
        }
    }

    init {
        updateUser(User(
                username = "admin",
                password = "admin",
                employee = null
        ))
    }
}