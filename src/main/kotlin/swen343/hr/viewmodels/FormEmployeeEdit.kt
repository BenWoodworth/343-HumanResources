package swen343.hr.viewmodels

import swen343.hr.models.Employee
import swen343.hr.models.User

/**
 * Created by ben on 11/6/17.
 */
class FormEmployeeEdit(
        override val sessionUser: User?,
        override val fields: FormEmployeeEdit.Fields,
        val employee: Employee
) : Form<FormEmployeeEdit.Fields>({
    if (fields.firstName.isEmpty()) {
        errors += "First name must not be empty"
    } else if (!Regex("^[a-zA-Z]+\$").matches(fields.firstName)) {
        errors += "First name must only contain letters"
    }

    if (fields.lastName.isEmpty()) {
        errors += "Last name must not be empty"
    } else if (!Regex("^[a-zA-Z]+\$").matches(fields.lastName)) {
        errors += "Last name must only contain letters"
    }

    if (fields.title.isEmpty()) {
        errors += "Title must not be empty"
    } else if (!Regex("^[a-zA-Z ]+\$").matches(fields.title)) {
        errors += "Title must only contain letters and spaces"
    }

    if (fields.department.isEmpty()) {
        errors += "Department must not be empty"
    } else if (!Regex("^[a-zA-Z ]+\$").matches(fields.lastName)) {
        errors += "Department must only contain letters"
    }

    if (!Regex("^\\d+\$").matches(fields.salary)) {
        errors += "Salary must be a non-negative integer"
    }

//    if (!Regex("^\\d{3}-\\d{3}-\\d{4}$").matches(fields.phoneNumber)) {
//        errors += "Phone number must have the format ###-###-####"
//    }

    if (!Regex("^\\d{10}$").matches(fields.phoneNumber)) {
        errors += "Phone number must have the format ##########"
    }

    if (!Regex("^\\w*@\\w*\\.\\w*$").matches(fields.email)) {
        errors += "Invalid email"
    }
}) {

    class Fields(
            val firstName: String,
            val lastName: String,
            val title: String,
            val department: String,
            val salary: String,
            val phoneNumber: String,
            val email: String,
            val address: String
    ) {
        constructor(employee: Employee) : this(
                firstName = employee.firstName,
                lastName = employee.lastName,
                title = employee.title,
                department = employee.department,
                salary = employee.salary.toString(),
                phoneNumber = employee.phoneNumber,
                email = employee.email,
                address = employee.address
        )
    }
}