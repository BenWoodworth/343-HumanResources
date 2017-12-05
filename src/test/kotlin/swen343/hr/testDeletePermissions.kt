package swen343.hr

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class testDeletePermissions:Spek({
    describe("Test deleting permissions for Human Resources/HR"){
        it("User should be able to delete permissions for Human resources"){}
        it("User should not be able delete permissions for human resources"){}
    }
    describe("Test deleting permissions for Accounting"){
        it("User should be able to delete permissions for accounting"){}
        it("User should not be able delete permissions for accounting"){}
    }
    describe("Test deleting permissions for Sales"){
        it("User should be able to delete permissions for Sales"){}
        it("User should not be able delete permissions for Sales"){}
    }
    describe("Test deleting permissions for customer support"){
        it("User should be able to delete permissions for customer support"){}
        it("User should not be able delete permissions for customer support"){}
    }
    describe("Tests deleting permissions for manufacturing"){
        it("User should be able to delete permissions for manufacturing"){}
        it("User should not be able delete permissions for manufacturing"){}
    }
    describe("Test deleting permissions for inventory management"){
        it("User should be able to delete permissions for inventory management"){}
        it("User should not be able delete permissions for inventory management"){}
    }

})