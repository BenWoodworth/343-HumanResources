package swen343.hr.util

/**
 * Updates updatable objects.
 *
 * @param revisions the updates made to the object over time
 * @param T the type of object to be updated
 */
abstract class Updater<in T : Updatable>(
        private vararg val revisions: T.() -> Unit
) {

    /**
     * Updates an object.
     *
     * @param updatable the object to be updated
     */
    fun update(updatable: T) {
        var revision = updatable.revision ?: -1
        val oldRevision = revision

        if (revision < 0) {
            initialize(updatable)
            revision++
        }

        while (revision < revisions.size) {
            revisions[revision++](updatable)
        }

        if (revision != oldRevision) {
            updatable.revision = revision
            finalize(updatable)
        }
    }

    /**
     * Code to be run for objects that aren't setup.
     *
     * @param updatable the object to initialize
     */
    abstract fun initialize(updatable: T)

    /**
     * Code to be run after updates have been made.
     *
     * @param updatable the object to finalize
     */
    abstract fun finalize(updatable: T)
}