package swen343.hr.models

data class User(
        val username: String,
        val password: String,
        val employee: Employee?
)
