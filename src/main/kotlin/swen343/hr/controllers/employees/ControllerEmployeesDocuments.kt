package swen343.hr.controllers.employees

import spark.RouteGroup
import spark.kotlin.delete
import spark.kotlin.get
import spark.kotlin.post
import swen343.hr.Permissions
import swen343.hr.dependencies.EmployeeDocumentService
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.util.RouteUtil
import swen343.hr.viewmodels.ViewModelDocuments
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ControllerEmployeesDocuments @Inject constructor(
        private val employeeDocumentService: EmployeeDocumentService,
        private val routeUtil: RouteUtil,
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {
        get("/view/:username/documents") {
            routeUtil.requirePerms(this, Permissions.HR_EMPLOYEES_VIEW)

            templateLoader.loadTemplate(
                    "/employees/documents.ftl",
                    ViewModelDocuments(
                            routeUtil.user(this),
                            employeeDocumentService.getDocuments(params("username"))
                    )
            )
        }

        // Upload
        post("/view/:username/documents") {
            TODO()
        }

        // Download
        get("/view/:username/documents/:filename") {
            TODO()
        }

        // Delete
        delete("/view/:username/documents/:filename") {
            TODO()
        }
    }
}