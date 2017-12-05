package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testEditUser : Spek({
    describe("Tests relating to editing users"){
        it("User should be able to edit the username of a user"){}
        it("User should be able to edit the password of a user"){}
        it("User should be able to edit the permissions of a user"){}
        it("Users should not be able to edit if there is no username"){}
        it("Users should not be able to edit if there is no password"){}
        it("Users should not be able to edit if there is no password confirmation"){}

    }

})