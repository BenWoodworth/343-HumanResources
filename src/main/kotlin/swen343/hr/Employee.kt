package swen343.hr

import java.util.*

data class Employee(
        val firstName: String,
        val lastName: String,
        val birthday: Date?,
        val phoneNumber: String,
        val altPhoneNumber: String?,
        val email: String,
        val address: String,
        val employeeID: Int,
        val username: String?,
        val password: String?,
        val title: String,
        val supervisor: String?,
        val payroll: Number,
        val salary: Int
)
