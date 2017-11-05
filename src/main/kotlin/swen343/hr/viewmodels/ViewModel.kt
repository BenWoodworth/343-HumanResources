package swen343.hr.viewmodels

import swen343.hr.models.User

interface ViewModel {

    /**
     * The user currently logged in.
     */
    val sessionUser: User?
}