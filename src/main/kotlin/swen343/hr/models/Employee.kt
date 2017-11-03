package swen343.hr.models

data class Employee(
        val id: Int = -1,
        val user: User,
        val firstName: String,
        val lastName: String,
        val title: String,
        val department: String,
        val salary: Int,
        val phoneNumber: String,
        val email: String,
        val address: String
)
