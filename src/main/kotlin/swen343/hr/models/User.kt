package swen343.hr.models

import swen343.hr.util.Permission

data class User(
        val id: Int = -1,
        val username: String,
        val passwordHash: String,
        val permissions: List<Permission>
) {

    fun hasPermission(permission: String): Boolean {
        return permissions.any { it.matches(permission) }
    }
}
