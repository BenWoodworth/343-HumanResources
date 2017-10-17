package swen343.hr.dependencies

import swen343.hr.models.Employee

interface EmployeeServiceInt {

    fun addEmployee()

    fun editEmployee(employee: Employee)

    fun deleteEmployee(employee: Employee)
}