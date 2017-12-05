package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testAddPermissions: Spek({
    describe("Test permissions for Human Resources/HR"){
        it("Users should be able to view Human resources"){}
        it("Users should not be able to view human resources"){}
    }
    describe("Test permissions for Accounting"){
        it("Users should be able to view accounting"){}
        it("Users should not be able to view accounting"){}
    }
    describe("Test permissions for Sales"){
        it("Users should be able to view Sales"){}
        it("Users should not be able to view Sales"){}
    }
    describe("Test permissions for customer support"){
        it("Users should be able to view customer support"){}
        it("Users should not be able to view customer support"){}
    }
    describe("Tests permissions for manufacturing"){
        it("Users should be able to view manufacturing"){}
        it("Users should not be able to view manufacturing"){}
    }
    describe("Test permissions for inventory management"){
        it("Users should be able to view inventory management"){}
        it("Users should not be able to view inventory management"){}
    }
})