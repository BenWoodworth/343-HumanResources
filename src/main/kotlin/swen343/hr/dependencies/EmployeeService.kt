package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee

@ImplementedBy(EmployeeServiceJdbc::class)
interface EmployeeService {

    fun getEmployees(): List<Employee>

    fun getEmployee(id: Int): Employee?

    fun addEmployee(
            firstName: String,
            lastName: String,
            title: String,
            department: String,
            salary: String,
            phoneNumber: String,
            email: String,
            address: String,
            picture: String
    ): Employee

    fun editEmployee(employee: Employee)

    fun deleteEmployee(id: Int)
}