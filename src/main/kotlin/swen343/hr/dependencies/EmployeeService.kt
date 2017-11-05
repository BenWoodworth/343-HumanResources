package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee

@ImplementedBy(EmployeeServiceMySql::class)
interface EmployeeService {

    /**
     * Get all the [Employee]s.
     *
     * @return all the [Employee]s
     */
    fun getEmployees(): List<Employee>

    /**
     * Get an [Employee].
     *
     * @param username the [Employee]'s username
     * @return the [Employee] with the given user, or `null` if it doesn't exist
     */
    fun getEmployee(username: String): Employee?

    /**
     * Adds a new [Employee]. The ID of the provided [Employee]
     * will be disregarded, and a new ID will be created.
     *
     * @param employee the [Employee] to add
     * @return the added [Employee]
     */
    fun addEmployee(employee: Employee): Employee

    /**
     * Edits an [Employee]'s info.
     *
     * @param employee the [Employee] to edit
     */
    fun editEmployee(employee: Employee)

    /**
     * Deletes an [Employee].
     */
    fun deleteEmployee(employee: Employee)
}