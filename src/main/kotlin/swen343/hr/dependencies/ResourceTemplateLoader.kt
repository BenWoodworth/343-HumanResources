package swen343.hr.dependencies

import java.io.File

/**
 * Load FreeMarker template from resources.
 */
class ResourceTemplateLoader : TemplateLoader {

    private val templatesDir = File(javaClass.getResource("/templates").toURI())

    private val freemarkerConf = freemarker.template.Configuration().apply {
        setDirectoryForTemplateLoading(templatesDir)

        defaultEncoding = "UTF-8"
        templateExceptionHandler = freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER
    }

    override fun loadTemplate(file: String, model: Any?): String {
        val template = freemarkerConf.getTemplate(file)

        val writer = java.io.StringWriter()

        template.process(model, writer)

        writer.flush()
        return writer.toString()
    }
}