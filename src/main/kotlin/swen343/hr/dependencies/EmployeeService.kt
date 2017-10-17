package swen343.hr.dependencies

import swen343.hr.models.Employee

interface EmployeeService {

    fun getEmployees(): List<Employee>

    fun getEmployee(id: Int): Employee?

    fun addEmployee(employee: Employee)

    fun editEmployee(employee: Employee)

    fun deleteEmployee(id: Int)
}