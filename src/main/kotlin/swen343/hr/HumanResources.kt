package swen343.hr

import spark.kotlin.get
import spark.kotlin.port

/**
 * Created by ben on 10/16/17.
 */
class HumanResources(
        private val templateLoader: TemplateLoader
) {

    fun start() {

        staticFiles.location("/public")
        staticFiles.expireTime(600)

        port(1234)

        get("/") {
            templateLoader.loadTemplate(
                    "index.ftl",
                    mapOf("ip" to request.ip())
            )
        }
    }

}