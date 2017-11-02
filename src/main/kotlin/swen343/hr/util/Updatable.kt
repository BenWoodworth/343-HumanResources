package swen343.hr.util

interface Updatable {

    /**
     * The current revision, or null if uninitialized.
     */
    var revision: Int?
}