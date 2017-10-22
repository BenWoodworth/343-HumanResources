package swen343.hr.viewmodels

import swen343.hr.models.Employee

/**
 * Created by ben on 10/16/17.
 */
data class ViewModelIndex(
        val ip: String,
        val employees: List<Employee>
)
