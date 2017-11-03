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
     * Register a new employee. The ID of the provided employee
     * will be ignored, and a new ID will be used.
     * created.
     *
     * @param employee the employee to add
     * @return a the registered employee
     */
    fun addEmployee(employee: Employee): Employee

    /**
     * Updates an employee's info.
     */
    fun updateEmployee(employee: Employee)

    /**
     * Deletes an employee.
     */
    fun deleteEmployee(employee: Employee)
}