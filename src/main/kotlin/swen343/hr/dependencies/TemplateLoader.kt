package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.viewmodels.ViewModel

/**
 * Loads FreeMarker templates.
 */
@ImplementedBy(TemplateLoaderResource::class)
interface TemplateLoader {

    /**
     * Load a FreeMarker template.
     */
    fun loadTemplate(file: String, model: ViewModel? = null): String
}