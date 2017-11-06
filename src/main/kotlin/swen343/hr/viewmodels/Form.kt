package swen343.hr.viewmodels

/**
 * Created by ben on 11/6/17.
 */
abstract class Form(
        /**
         * Validators to validate individual fields.
         * Returns `null` if valid, or a validation
         * error if invalid.
         */
        private vararg val validators: () -> String?
) : ViewModel {

    var validation: ValidationResult? = null

    /**
     * Validate the inputs, and update [validation].
     *
     * @return true iff all inputs are valid
     */
    fun validate(): Boolean {
        val errors = mutableListOf<String>()

        for (validator in validators) {
            validator()?.let {
                errors += it
            }
        }

        val result = ValidationResult(
                valid = errors.isEmpty(),
                errors = errors
        )

        validation = result
        return result.valid
    }

    data class ValidationResult(
            val valid: Boolean,
            val errors: List<String>
    )
}