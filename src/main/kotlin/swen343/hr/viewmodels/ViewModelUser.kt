package swen343.hr.viewmodels

import swen343.hr.models.User
import java.text.NumberFormat
import java.util.*

data class ViewModelUser(
        override val sessionUser: User?,
        val user: User
) : ViewModel {

    val permissions = user.permissions.map { it.permission }

    val permsNewLine = user.permissions.joinToString("\n")
}