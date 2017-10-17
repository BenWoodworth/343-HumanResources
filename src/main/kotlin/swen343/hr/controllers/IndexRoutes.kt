package swen343.hr.controllers

import spark.RouteGroup
import spark.Spark.path
import spark.kotlin.get
import spark.kotlin.staticFiles
import swen343.hr.controllers.api.ApiRoutes
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.IndexViewModel


class IndexRoutes(
        private val templateLoader: TemplateLoader
) : RouteGroup {

    override fun addRoutes() {
        staticFiles.location("/public")

        path("/api", ApiRoutes())

        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    IndexViewModel(request.ip())
            )
        }
    }
}