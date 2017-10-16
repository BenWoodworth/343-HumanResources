package swen343.hr

/**
 * Loads FreeMarker templates.
 */
interface TemplateLoader {

    /**
     * Load a FreeMarker template.
     */
    fun loadTemplate(file: String, model: Map<String, Any>): String
}