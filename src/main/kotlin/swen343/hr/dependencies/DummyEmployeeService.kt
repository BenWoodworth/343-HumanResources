package swen343.hr.dependencies

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
class DummyEmployeeService : EmployeeService {

    private val employees = mutableListOf<Employee>()

    override fun addEmployee(employee: Employee) {
        deleteEmployee(employee)
        employees.add(employee)
    }

    override fun editEmployee(employee: Employee) {
        addEmployee(employee)
    }

    override fun deleteEmployee(employee: Employee) {
        employees.removeIf {
            it.id == employee.id
        }
    }
}