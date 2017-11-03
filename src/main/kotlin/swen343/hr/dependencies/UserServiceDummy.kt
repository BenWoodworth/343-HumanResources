package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.models.Employee
import swen343.hr.models.User

/**
 * Created by beltran on 11/01/17.
 */
@Singleton
class UserServiceDummy @Inject constructor(
        hashService: HashService
) : UserService {

    private val users = mutableListOf<User>()

    override fun getUsers(): List<User> {
        return users
                .sortedBy { it.id }
                .toList()
    }

    override fun getUser(id: Int): User? {
        return users.firstOrNull { it.id == id }
    }

    override fun getUser(username: String): User? {
        return users.firstOrNull { it.username == username }
    }

    override fun addUser(user: User): User {
        val id = users
                .map { it.id }
                .maxBy { it + 1 } ?: 0

        val newUser = User(
                id = id,
                username = user.username,
                passwordHash = user.passwordHash
        )

        users += newUser

        return newUser
    }

    override fun editUser(user: User) {
        users.removeIf { it.id == user.id }
        users += user
    }

    override fun deleteUser(user: User) {
        users.removeIf { it.id == user.id }
    }

    init {
        addUser(User(
                username = "admin",
                passwordHash = hashService.hash("password")
        ))

        addUser(User(
                username = "dummy",
                passwordHash = hashService.hash("password")
        ))
    }
}