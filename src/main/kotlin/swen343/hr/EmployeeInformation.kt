package swen343.hr

import java.util.*

data class EmployeeInformation (
        val firstName: String,
        val lastName: String,
        val birthday: Date,
        val phoneNumber: String,
        val altPhoneNumber: String,
        val email: String,
        val employeeID: String,
        val username: String,
        val password: String,
        val jobTitle: String,
        val supervisor: String,
        val payroll: Number,
        val salary: Currency
)
