package swen343.hr.util

import com.squareup.moshi.ToJson

/**
 * A permission.
 */
data class Permission(
        val permission: String
) {
    private val regex = Regex("^\\w+(\\.\\w+)*(\\.\\*)?\$")

    init {
        assert(regex.matches(permission)) {
            "Permission must match expression: $regex"
        }
    }

    private val parts = permission.split(".")

    /**
     * Check if permission string matches this [Permission].
     */
    fun matches(permString: String): Boolean {
        val testParts = permString.split(".")

        for (i in 0 until maxOf(parts.size, testParts.size)) {
            when {
                i >= parts.size -> return false
                parts[i] == "*" -> return true
                i >= testParts.size -> return false
                parts[i] != testParts[i] -> return false
            }
        }
        return true
    }

    override fun toString() = permission

    @ToJson
    private fun toJson() = permission
}