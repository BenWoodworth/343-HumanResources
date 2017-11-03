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
            it.email == username
        }
    }

    override fun updateUser(user: User) {
        deleteUser(user.email)
        users.add(user)
    }

    override fun deleteUser(username: String) {
        users.removeIf {
            it.email == username
        }
    }

    init {
        updateUser(User(
                email = "admin@kennuware.com",
                password = "admin",
                department = "sales"
        ))
    }
}