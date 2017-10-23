package swen343.hr.dependencies

import com.google.inject.ImplementedBy

/**
 * Loads FreeMarker templates.
 */
@ImplementedBy(TemplateLoaderResource::class)
interface TemplateLoader {

    /**
     * Load a FreeMarker template.
     */
    fun loadTemplate(file: String, model: Any? = null): String
}