package swen343.hr.dependencies

import swen343.hr.models.Employee

interface EmployeeService {

    fun addEmployee(employee: Employee)

    fun editEmployee(employee: Employee)

    fun deleteEmployee(employee: Employee)
}