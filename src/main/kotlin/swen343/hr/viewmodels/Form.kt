package swen343.hr.viewmodels

/**
 * Created by ben on 11/6/17.
 */
abstract class Form<out TFields>(
        /**
         * Validators to validate individual fields.
         * Returns `null` if valid, or a validation
         * error if invalid.
         */
        private vararg val validators: ValidationData<TFields>.() -> Unit
) : ViewModel {

    /**
     * The form's fields.
     */
    abstract val fields: TFields

    var validation: ValidationResult? = null

    /**
     * Validate the inputs, and update [validation].
     *
     * @return true iff all inputs are valid
     */
    fun validate(): Boolean {
        val errors = mutableListOf<String>()

        for (validator in validators) {
            errors += mutableListOf<String>().apply {
                validator(ValidationData(fields, this))
            }
        }

        val result = ValidationResult(
                valid = errors.isEmpty(),
                errors = errors
        )

        validation = result
        return result.valid
    }

    data class ValidationData<out TFields>(
            val fields: TFields,
            val errors: MutableList<String> = mutableListOf()
    )

    data class ValidationResult(
            val valid: Boolean,
            val errors: List<String>
    )
}