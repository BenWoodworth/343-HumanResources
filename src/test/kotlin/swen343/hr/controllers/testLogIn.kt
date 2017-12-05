package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testLogin : Spek({

    describe("Testing logging in"){
        it("Should log in when provided a correct username and password."){}
        it("Should not log in with the wrong username "){}
        it("Should not log in with the wrong password "){}
    }


    describe("Testing signing out"){
        it("Should sign out when hitting the sign out buttons"){}
        it("Should not sign out when a user is not logged in"){}
    }

})