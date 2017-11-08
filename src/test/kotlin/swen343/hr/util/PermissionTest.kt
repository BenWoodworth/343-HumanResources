package swen343.hr.util

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.*

class PermissionTest : Spek({
    describe("Permissions for a.b") {
        val permission = Permission("a.b")

        it("Should not match a") {
            val perm = permission.matches("a")
            assertFalse(perm)
        }

        it("Should match a.b") {
            val matches = permission.matches("a.b")
            assertTrue(matches)
        }

        it("Should not match a.c") {
            val matches = permission.matches("a.c")
            assertFalse(matches)
        }

        it("Should not match a.b.c") {
            val perm = permission.matches("a.b.c")
            assertFalse(perm)
        }
    }

    describe("Permissions for a.*") {
        val permission = Permission("a.*")

        it("Should not match a") {
            val perm = permission.matches("a")
            assertFalse(perm)
        }

        it("Should match a.b") {
            val matches = permission.matches("a.b")
            assertTrue(matches)
        }

        it("Should not match a.b.c") {
            val perm = permission.matches("a.b.c")
            assertFalse(perm)
        }
    }

    describe("Permissions for a.**") {
        val permission = Permission("a.**")

        it("Should not match a") {
            val perm = permission.matches("a")
            assertFalse(perm)
        }

        it("Should match a.b") {
            val matches = permission.matches("a.b")
            assertTrue(matches)
        }

        it("Should match a.b.c") {
            val perm = permission.matches("a.b.c")
            assertTrue(perm)
        }
    }

})