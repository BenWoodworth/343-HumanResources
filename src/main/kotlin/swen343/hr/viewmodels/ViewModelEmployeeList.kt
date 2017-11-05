package swen343.hr.viewmodels

import swen343.hr.models.Employee
import swen343.hr.models.User

data class ViewModelEmployeeList(
        override val sessionUser: User?,
        val employees: List<Employee>
) : ViewModel