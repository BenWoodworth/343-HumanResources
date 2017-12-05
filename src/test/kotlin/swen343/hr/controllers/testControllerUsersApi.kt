package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerUsersApi: Spek({
    describe("Test the routes in controllerUsers Api"){
        it("User can access the list of users from the api/users/ path"){}
        it("User can access a user's info from getting the api/users/:username path"){}
        it("User can access a user's permissiong by getting the api/users/:username/has-perm/:permission path"){}
    }
})