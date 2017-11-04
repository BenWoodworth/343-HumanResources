package swen343.hr.viewmodels

import swen343.hr.models.Employee
import java.text.NumberFormat
import java.util.*

data class ViewModelEmployee(
        val employee: Employee
) {

    val salary: String
        get() = "\$${
            NumberFormat
                    .getNumberInstance(Locale.US)
                    .format(employee.salary)
        }"
}