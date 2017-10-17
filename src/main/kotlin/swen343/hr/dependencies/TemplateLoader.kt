package swen343.hr.dependencies

/**
 * Loads FreeMarker templates.
 */
interface TemplateLoader {

    /**
     * Load a FreeMarker template.
     */
    fun loadTemplate(file: String, model: Any? = null): String
}