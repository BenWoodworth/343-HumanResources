package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testAddEmployee : Spek({
    describe("Tests for adding an employee to the system"){
        it("User should be able to add an employee if all fields are filled"){}
        it("User should not be added to the system if no fields are filled"){}
        it("User should not be able to add an employee if missing a Username"){}
        it("User should not be able to add an employee if missing a First Name"){}
        it("User should not be able to add an employee if missing a Last Name"){}
        it("User should not be able to add an employee if missing a Title"){}
        it("User should not be able to add an employee if missing a department"){}
        it("User should not be able to add an employee if missing a Salary"){}
        it("User should not be able to add an employee if missing a Phone Number"){}
        it("User should not be able to add an employee if missing an email"){}
    }
})