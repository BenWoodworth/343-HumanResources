package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testEditEmployee : Spek({

    describe("Users should be able to edit the fields of a user"){
        it("User should be able to edit an employee if First Name is changed"){}
        it("User should be able to edit an employee if Last Name is changed"){}
        it("User should be able to edit an employee if Title is changed"){}
        it("User should be able to edit an employee if Department is changed"){}
        it("User should be able to edit an employee if Salary is changed"){}
        it("User should be able to edit an employee if Address is changed"){}
        it("User should be able to edit an employee if Phone Number is changed"){}
        it("User should be able to edit an employee if E-mail address is changed"){}
        it("User should not be able to edit an employee if First Name is empty"){}
        it("User should not be able to edit an employee if Last Name is empty"){}
        it("User should not be able to edit an employee if Title is empty"){}
        it("User should not be able to edit an employee if Department is empty"){}
        it("User should not be able to edit an employee if Salary is empty"){}
        it("User should not be able to edit an employee if Address is empty"){}
        it("User should not be able to edit an employee if Phone Number is changed"){}
        it("User should not be able to edit an employee if E-mail address is changed"){}
    }
})