package swen343.hr.controllers

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testControllerAuth: Spek({

    describe("Tests to the paths in addRoutes()"){
        it("Users are able to log in using by getting the auth/login path"){}
        it("Users are able to log in by posting to the auth/login path"){}
        it("Users are able to sign out by using the auth/sign-out path"){}
    }
})