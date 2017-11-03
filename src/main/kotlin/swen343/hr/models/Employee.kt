package swen343.hr.models

data class Employee(
        val id: Int,
        val user: User,
        val firstName: String,
        val lastName: String,
        val title: String,
        val department: String,
        val salary: String,
        val phoneNumber: String,
        val email: String,
        val address: String
)
