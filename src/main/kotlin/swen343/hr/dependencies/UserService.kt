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
     * @param id the [User]'s id
     * @return the [User] with the given id, or `null` if it doesn't exist
     */
    fun getUser(id: Int): User?

    /**
     * Get a [User].
     *
     * @param username the [User]'s username
     * @return the [User] with the given username, or `null` if it doesn't exist
     */
    fun getUser(username: String): User?

    /**
     * Adds a new [User]. The ID of the provided [User]
     * will be disregarded, and a new ID will be created.
     *
     * @param user the [User] to add
     * @return the added [User]
     */
    fun addUser(user: User): User

    /**
     * Edits a [User]'s info.
     *
     * @param user the [User] to edit
     * @return the updated [User]
     */
    fun editUser(user: User)

    /**
     * Deletes a [User].
     */
    fun deleteUser(user: User)
}