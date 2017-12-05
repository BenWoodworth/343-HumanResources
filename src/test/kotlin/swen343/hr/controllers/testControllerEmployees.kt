package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerEmployees : Spek({
    describe("Tests for addRoutes function"){
        it("User should be able to view employees by getting the 'employee/' path"){}
        it("User should be able to add employees by getting the employee/add path"){}
        it("User should be able to add employees by posting the employee/add path"){}
        it("User should be able to edit employees by getting the employee/edit/:username path"){}
        it("User should be able to edit employees by posting the employee/edit/:username path"){}
        it("User should be able to delete employees by getting the employee/delete/:username path"){}
        it("User should be bale to view employees by getting the employee/view/:username path"){}

    }
})