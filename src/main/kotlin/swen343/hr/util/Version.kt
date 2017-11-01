package swen343.hr.util

/**
 * Created by ben on 11/1/17.
 */
data class Version(
        val major: Int,
        val minor: Int,
        val patch: Int
) : Comparable<Version> {

    init {
        assert(major > 0)
        assert(minor > 0)
        assert(patch > 0)
    }

    companion object {
        fun fromString(version: String): Version {
            val regex = Regex("^v?(\\d+)(?:.(\\d+))?(?:.(\\d+))?\$")

            val match = regex.matchEntire(version)
                    ?: throw IllegalArgumentException("Invalid version: $version")

            val (major, minor, patch) = match.destructured

            return Version(
                    major.toIntOrNull() ?: 0,
                    minor.toIntOrNull() ?: 0,
                    patch.toIntOrNull() ?: 0
            )
        }
    }

    override fun compareTo(other: Version) = when {
        major != other.major -> major - other.major
        minor != other.minor -> minor - other.minor
        else -> patch - other.patch
    }

    override fun toString() = "$major.$minor.$patch"
}
