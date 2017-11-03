package swen343.hr.models

data class User(
        val id: Int = -1,
        val username: String,
        val passwordHash: List<Byte>
)
