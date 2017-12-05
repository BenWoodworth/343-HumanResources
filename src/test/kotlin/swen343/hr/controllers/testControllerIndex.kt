package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerIndex: Spek({
    describe("Tests for addRoutes in the Index."){
        it("Users access controllerApi by using the path /api"){}
        it("Users access controllerEmployees by using the path /employees"){}
        it("Users access controllerUsers by using the path /users"){}
        it("Users access controllerAuth by using the path /auth"){}
        it("Users are redirected to the log in when not logged in when getting the '/' path"){}
        it("Users are directed to the silos page when signed in when getting the /silos path"){}
    }

})