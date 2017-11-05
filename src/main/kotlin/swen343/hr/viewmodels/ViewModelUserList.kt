package swen343.hr.viewmodels

import swen343.hr.models.User

data class ViewModelUserList(
        override val sessionUser: User?,
        val users: List<User>
) : ViewModel