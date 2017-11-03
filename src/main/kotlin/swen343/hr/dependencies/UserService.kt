package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.User

@ImplementedBy(UserServiceDummy::class)
interface UserService {

    fun getUsers(): List<User>

    fun getUser(username: String): User?

    fun updateUser(user: User)

    fun deleteUser(username: String)
}