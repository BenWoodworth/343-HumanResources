package swen343.hr.viewmodels

import swen343.hr.models.Employee
import swen343.hr.models.User
import java.text.NumberFormat
import java.util.*

data class ViewModelEmployee(
        override val sessionUser: User?,
        val employee: Employee
) : ViewModel {

    val salary: String
        get() = "\$${
            NumberFormat
                    .getNumberInstance(Locale.US)
                    .format(employee.salary)
        }"
}