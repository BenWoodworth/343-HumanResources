package swen343.hr

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import java.io.File
import java.io.StringWriter

/**
 * Load FreeMarker template from resources.
 */
class ResourceTemplateLoader : TemplateLoader {

    private val templatesDir = File(javaClass.getResource("templates").toURI())

    private val freemarkerConf = Configuration().apply {
        setDirectoryForTemplateLoading(templatesDir)

        defaultEncoding = "UTF-8"
        templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
    }

    override fun loadTemplate(file: String, model: Map<String, Any>): String {
        val template = freemarkerConf.getTemplate(file)

        val writer = StringWriter()

        template.process(model, writer)

        writer.flush()
        return writer.toString()
    }
}