package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee
import swen343.hr.models.User

@ImplementedBy(EmployeeServiceMySql::class)
interface EmployeeService {

    /**
     * Get all the employees.
     *
     * @return all the employees
     */
    fun getEmployees(): List<Employee>

    /**
     * Get an employee.
     *
     * @param username the employee's username
     * @return the employee with the given username, or `null` if it doesn't exist
     */
    fun getEmployee(user: User): Employee?

    /**
     * Updates an employee's info, or adds the
     * employee if it doesn't exist.
     */
    fun updateEmployee(employee: Employee)

    /**
     * Deletes an employee.
     */
    fun deleteEmployee(username: String)
}