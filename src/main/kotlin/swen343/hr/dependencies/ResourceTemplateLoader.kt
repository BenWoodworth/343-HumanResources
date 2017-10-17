package swen343.hr.dependencies

/**
 * Load FreeMarker template from resources.
 */
class ResourceTemplateLoader : TemplateLoader {

    private val templatesDir = java.io.File(javaClass.getResource("/templates").toURI())

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