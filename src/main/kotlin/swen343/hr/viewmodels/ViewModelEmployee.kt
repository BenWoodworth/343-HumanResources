package swen343.hr.viewmodels

import swen343.hr.models.Employee

data class ViewModelEmployee(
        val employee:Employee
){
    val formattedSalary:String
    get() = employee.salary.toString()
}