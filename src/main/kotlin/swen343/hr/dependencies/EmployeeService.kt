package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee
import swen343.hr.models.User

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
     * @param user the [Employee]'s user
     * @return the [Employee] with the given user, or `null` if it doesn't exist
     */
    fun getEmployee(user: User): Employee?

    /**
     * Updates an [Employee]'s info. If the provided
     * [Employee]'s `id` is null, registers a new [Employee]
     *
     * @param employee the [Employee] to update
     * @return the updated [Employee]
     */
    fun updateEmployee(employee: Employee): Employee

    /**
     * Deletes an [Employee].
     */
    fun deleteEmployee(employee: Employee)
}