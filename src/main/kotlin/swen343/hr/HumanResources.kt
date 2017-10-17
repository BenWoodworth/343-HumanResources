package swen343.hr

import spark.kotlin.get
import spark.kotlin.port
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.viewmodels.IndexViewModel

/**
 * Created by ben on 10/16/17.
 */
class HumanResources(
        private val templateLoader: TemplateLoader
) {

    fun start() {
        port(1234)

        get("/") {

            templateLoader.loadTemplate(
                    "index.ftl",
                    IndexViewModel(request.ip())
            )
        }
    }
}