package swen343.hr.viewmodels

import swen343.hr.models.User

class ViewModelBasic(
        override val sessionUser: User?
) : ViewModel