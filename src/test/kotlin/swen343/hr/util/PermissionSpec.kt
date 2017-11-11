package swen343.hr.util

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.*

class PermissionSpec : Spek({
    describe("Permissions for a") {
        val permission = Permission("a")

        it("Should match a") {
            assertTrue(permission.matches("a"))
        }

        it("Should not match b") {
            assertFalse(permission.matches("b"))
        }

        it("Should not match a.b") {
            assertFalse(permission.matches("a.b"))
        }
    }

    describe("Permissions for a.b") {
        val permission = Permission("a.b")

        it("Should not match a") {
            assertFalse(permission.matches("a"))
        }

        it("Should match a.b") {
            assertTrue(permission.matches("a.b"))
        }

        it("Should not match a.c") {
            assertFalse(permission.matches("a.c"))
        }

        it("Should not match a.b.c") {
            assertFalse(permission.matches("a.b.c"))
        }
    }

    describe("Permissions for a.*") {
        val permission = Permission("a.*")

        it("Should match a") {
            assertTrue(permission.matches("a"))
        }

        it("Should match a.b") {
            assertTrue(permission.matches("a.b"))
        }

        it("Should match a.b.c") {
            assertTrue(permission.matches("a.b.c"))
        }

        it("Should not match b.c") {
            assertFalse(permission.matches("b.c"))
        }
    }
})