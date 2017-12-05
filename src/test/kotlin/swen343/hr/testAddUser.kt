package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testAddUser : Spek({
    describe("Tests for creating a user"){
        it("User should be able to create a User"){}
        it("User should not be able to create a User if User name is missing"){}
        it("User should not be able to create a User if Password is missing"){}

    }
})