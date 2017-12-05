package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerUsers : Spek({
    describe("Test the routes for the ControllerUsers class"){
        it("Users can access the user list by getting the 'user/' path"){}
        it("Users can add to the user list by getting the user/add path"){}
        it("Users can add to the user list by posting to the user/add path"){}
        it("Users can edit to the user list by getting the user/edit/:username path"){}
        it("Users can edit the user list by posting to the user/edit/:username"){}
        it("User can delete a user from the list by getting the user/delete/:username path"){}
        it("User can view a user from the list by getting the user/view/:username path"){}
    }
})
