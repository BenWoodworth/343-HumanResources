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

    override fun getUser(email: String): User? {
        return users.firstOrNull {
            it.email == email
        }
    }

    override fun updateUser(user: User) {
        deleteUser(user.email)
        users.add(user)
    }

    override fun deleteUser(email: String) {
        users.removeIf {
            it.email == email
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