package swen343.hr.util

/**
 * A permission.
 *
 * Format:
 *  Made up of sub-perms separated by periods.
 *  Sub-perms can contain characters `a-zA-Z0-9_-`
 *  Sub-perms can use asterisk as a wild card.
 *  Last sub-perm can be a double asterisk to match the rest.
 *
 * Example permissions:
 *  hr.employees.add
 *  hr.employees.edit
 *  hr.employees.*
 *  hr.*.add
 *  hr.**
 *
 * Invalid permissions:
 *  hr.**.add
 */
data class Permission(
        val permission: String
) {
    private val regex = Regex("^(([\\w-]+|\\*)\\.)*([\\w-]+|\\*\\*?)\$")

    init {
        assert(regex.matches(permission)) {
            "Permission must match expression: $regex"
        }
    }

    private val parts = permission.split("\\.")

    /**
     * Check if permission string matches this [Permission].
     */
    fun matches(permString: String): Boolean {
        val testParts = permString.split("\\.")

        for (i in 0 until maxOf(parts.size, testParts.size)) {
            when {
                i >= parts.size -> return false
                i >= testParts.size -> return false
                parts[i] == "**" -> return true
                parts[i] == "*" -> Unit
                parts[i] != testParts[i] -> return false
            }
        }

        return true
    }

    override fun toString() = permission
}