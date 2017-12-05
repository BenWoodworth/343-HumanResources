package swen343.hr.controllers.employees

import spark.RouteGroup
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.EmployeeDocumentService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.ViewModelDocuments
import javax.inject.Inject
import javax.inject.Singleton
import javax.servlet.MultipartConfigElement
import spark.kotlin.halt
import swen343.hr.dependencies.EmployeeService
import java.nio.file.Files

@Singleton
class ControllerEmployeesDocuments @Inject constructor(
        private val employeeDocumentService: EmployeeDocumentService,
        private val employeeService: EmployeeService,
        private val routeUtil: RouteUtil,
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {
        get("view/:username/documents/") {
            val username = request.params("username")
            val employee = employeeService.getEmployee(username)
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_VIEW)

            templateLoader.loadTemplate(
                    "/employees/documents.ftl",
                    ViewModelDocuments(
                            sessionUser = routeUtil.user(this),
                            employee = employee,
                            documentPaths = employeeDocumentService.getDocuments(params("username"))
                    )
            )
        }

        // Upload
        post("view/:username/documents/") {
            request.attribute(
                    "org.eclipse.jetty.multipartConfig",
                    MultipartConfigElement("/temp")
            )

            val document = request.raw().getPart("document")

            employeeDocumentService.uploadDocument(
                    params("username"),
                    document.submittedFileName,
                    document.inputStream
            )

            response.redirect(".")
        }

        // Download
        get("view/:username/documents/download/:filename") {
            val path = employeeDocumentService.getDocument(
                    params("username"),
                    params("filename")
            )

            path ?: throw halt(404)

            response.header("Content-Disposition", "attachment; filename=${path.fileName}")
            response.type("application/force-download")

            response.raw().apply {
                outputStream.use {
                    Files.copy(path, it)
                }
            }
        }

        // Delete
        post("view/:username/documents/delete/:filename") {
            val username = request.params("username")
            val doc = request.params("filename")
            val employee = username?.let {
                employeeService.getEmployee(it)
            }
            val document = employee?.let {
                employeeDocumentService.getDocument(username, doc)
            }
            if (document != null) {
                employeeDocumentService.deleteDocument(username, doc)
            }
            response.redirect("..")
        }
    }
}