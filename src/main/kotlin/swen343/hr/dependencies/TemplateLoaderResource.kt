package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.viewmodels.ViewModel

/**
 * Load FreeMarker template from resources.
 */
@Singleton
class TemplateLoaderResource : TemplateLoader {

    private val freemarkerConf = freemarker.template.Configuration().apply {
        setClassForTemplateLoading(javaClass, "/templates")

        defaultEncoding = "UTF-8"
        templateExceptionHandler = freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER
    }

    override fun loadTemplate(file: String, model: ViewModel?): String {
        val template = freemarkerConf.getTemplate(file)

        val writer = java.io.StringWriter()

        template.process(model, writer)

        writer.flush()
        return writer.toString()
    }
}