package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee
import swen343.hr.models.User

@ImplementedBy(UserServiceDummy::class)
interface UserService {

    /**
     * Get all the registered [User]s.
     *
     * @return all the users
     */
    fun getUsers(): List<User>

    /**
     * Get a [User].
     *
     * @param username the [User]'s username
     * @return the [User] with the given username, or `null` if it doesn't exist
     */
    fun getUser(username: String): User?

    /**
     * Updates an [User]'s info. If the provided
     * [User]'s `id` is null, registers a new [User]
     *
     * @param user the [User] to update
     * @return the updated [User]
     */
    fun updateUser(user: User): Employee

    /**
     * Deletes a [User].
     */
    fun deleteUser(user: User)
}